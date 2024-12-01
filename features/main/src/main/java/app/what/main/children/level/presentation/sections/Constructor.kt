package app.what.main.children.level.presentation.sections

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.what.foundation.core.Listener
import app.what.foundation.services.LocalSheetProvider
import app.what.foundation.ui.Space
import app.what.foundation.ui.useState
import app.what.main.children.level.domain.game.Command
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState
import app.what.ui.icons.ChevronsDownUp
import app.what.ui.icons.ChevronsUpDown
import app.what.ui.icons.Minus
import app.what.ui.icons.Plus
import app.what.ui.icons.WHATIcons

fun commandSheet(state: LevelState, listener: Listener<LevelEvent>, command: Command<*>) =
    @Composable {
        val sheetProvider = LocalSheetProvider.current

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            item {
                Text("Выберите команду чтобы добавить")
            }

            items(state.board.availableCommands, key = { it.id }) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            command.children += it.copy()
                            sheetProvider.animateClose()
                        }
                ) {
                    Column {
                        Text(it.name)
                        Space(4)
                        Text(it.description)
                    }
                }
            }
        }
    }

@Composable
fun Constructor(
    state: LevelState,
    listener: Listener<LevelEvent>
) = Column(
    Modifier.padding(8.dp)
) {
    state.commandRoot ?: return@Column

    CommandComponent(state, listener, null, state.commandRoot)
}

@Composable
fun AddCommandButton(state: LevelState, listener: Listener<LevelEvent>, to: Command<*>) {
    val sheetProvider = LocalSheetProvider.current

    Icon(
        imageVector = WHATIcons.Plus,
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                sheetProvider.setContent(commandSheet(state, listener, to))
                sheetProvider.open()
            }
    )
}

@Composable
fun CommandComponent(
    state: LevelState,
    listener: Listener<LevelEvent>,
    parent: Command<*>? = null,
    command: Command<*>
) {
    val (expanded, setExpanded) = useState(false)

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    if (state.currentCommandId == command.id) Color.Blue
                    else Color.Transparent
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (command.availableNested) Icon(
                    imageVector = if (expanded) WHATIcons.ChevronsDownUp
                    else WHATIcons.ChevronsUpDown,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { setExpanded(!expanded) }
                )

                Space(8)

                Text(command.name)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                command.content()

                if (command.availableNested)
                    AddCommandButton(state, listener, command)

                Space(8)

                if (command.removable) Icon(
                    imageVector = WHATIcons.Minus,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable {
                            if (parent != null) parent.children =
                                parent.children.filter { it.id != command.id }
                        }
                )
            }
        }

        AnimatedVisibility(expanded) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                command.children.forEach {
                    CommandComponent(state, listener, command, it)
                }
            }
        }
    }
}