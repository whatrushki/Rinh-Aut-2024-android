package app.what.code_cadet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.what.foundation.services.ProvideGlobalSheet
import app.what.main.children.level.navigation.LevelProvider
import app.what.main.children.level.presentation.LevelFeature
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            CodeCadetTheme {
            ProvideGlobalSheet {
                val some = remember { LevelFeature(LevelProvider) }
                some.content(Modifier)
            }
        }
//            }
    }
}

data class CommandData(
    val id: UUID = UUID.randomUUID(), // Уникальный ID для каждой команды
    val name: String,
    val children: MutableList<CommandData> = mutableListOf() // MutableList для изменения
)


@Composable
fun CommandTree(
    commands: MutableList<CommandData>, // MutableList для изменения
    onCommandClick: (CommandData) -> Unit
) {
    var draggedItem by remember { mutableStateOf<CommandData?>(null) }
    var targetItem by remember { mutableStateOf<CommandData?>(null) }

    LazyColumn {
        items(commands, key = { it.id }) { command -> // key для рекомпозиции
            val offsetX = remember { mutableStateOf(0f) }
            val offsetY = remember { mutableStateOf(0f) }

            CommandItem(
                command = command,
                onCommandClick = onCommandClick,
                modifier = Modifier
                    .graphicsLayer {
                        translationX = if (command == draggedItem) offsetX.value else 0f
                        translationY = if (command == draggedItem) offsetY.value else 0f
                    }
                    .pointerInput(Unit) {
                        detectDragGesturesAfterLongPress(
                            onDragStart = {
                                draggedItem = command
                            },
                            onDragEnd = {
                                if (targetItem != null && draggedItem != null) {
                                    moveCommand(draggedItem!!, targetItem!!, commands)
                                }

                                draggedItem = null
                                targetItem = null
                            },
                            onDragCancel = {
                                draggedItem = null
                                targetItem = null
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                offsetX.value += dragAmount.x
                                offsetY.value += dragAmount.y
                                // находим element над которым
                                // пока простой вариант с вычислением по смещению
                            }
                        )
                    }
                    .onGloballyPositioned {
                    },
                isTarget = command == targetItem

            )
        }


    }

}


@Composable
fun CommandItem(
    command: CommandData,
    onCommandClick: (CommandData) -> Unit,
    modifier: Modifier = Modifier,
    isTarget: Boolean = false

) {

    var expanded by remember { mutableStateOf(false) }
    val backgroundColor = if (isTarget) Color.LightGray else Color.Transparent

    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(horizontal = 8.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (command.children.isNotEmpty()) {
                    expanded = !expanded
                } else {
                    onCommandClick(command)
                }
            }
        ) {
            if (command.children.isNotEmpty()) {
                Icon(
                    imageVector = if (expanded) Icons.Default.ArrowDropDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            } else {
                Spacer(Modifier.size(16.dp)) //  add space if there is no children for text align
            }

            Text(
                text = command.name,
                fontWeight = if (command.children.isNotEmpty()) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )
        }

        // SubCommands
        if (expanded && command.children.isNotEmpty()) {
            Column(Modifier.padding(start = 16.dp)) {
                command.children.forEach { childCommand ->
                    CommandItem(command = childCommand,
                        modifier = Modifier
                            .onGloballyPositioned {}
                            .pointerInput(Unit) {},
                        onCommandClick = onCommandClick
                    )
                }
            }
        }
    }

}


private fun moveCommand(
    draggedItem: CommandData,
    targetItem: CommandData,
    commands: MutableList<CommandData>
) {
    // 1. Удаляем draggedItem из старого места

    removeCommand(draggedItem, commands)


    // 2. Добавляем draggedItem к targetItem в children

    targetItem.children.add(draggedItem)


}


fun removeCommand(
    commandToRemove: CommandData,
    commands: MutableList<CommandData>
) {
    //  сначала рекурсивно  удоляем child у родителя
    commands.remove(commandToRemove)
//  пробегаемся по children  рекурсивно ищем item,  для полной очистки дерева элементов, иначе могут быть дубликаты в дереве

    for (c in commands) {
        removeCommand(commandToRemove, c.children)
    }

}


@Preview(showBackground = true)
@Composable
fun CommandTreePreview() {

    val commands = remember {
        mutableStateListOf(

            CommandData(
                name = "Command 1", children = mutableListOf(
                    CommandData(name = "Subcommand 1.1"),
                    CommandData(
                        name = "Subcommand 1.2", children = mutableListOf(
                            CommandData(name = "Subcommand 1.2.1")
                        )
                    )
                )
            ),
            CommandData(name = "Command 2"),
            CommandData(name = "Command 3")
        )

    }

    CommandTree(commands = commands) { command ->
        println("Clicked on command: ${command.name}")
    }
}