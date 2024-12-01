package app.what.main.children.level.domain.game

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import app.what.foundation.core.monitored
import kotlinx.coroutines.delay
import java.util.UUID


sealed interface ExecutionResult {
    data class Success(
        val board: GameBoard
    ) : ExecutionResult

    data class Failure(
        val message: String? = null
    ) : ExecutionResult
}

data class Command<T : Any>(
    val name: String,
    val description: String,
    val removable: Boolean = true,
    val availableNested: Boolean = false,
    val initValue: T,
    private val fieldContent: @Composable (T, (T) -> Unit) -> Any,
    val action: suspend Command<T>.(GameBoard) -> ExecutionResult
) {
    var value: T by monitored(initValue)
    var content: @Composable () -> Any = { fieldContent(value, ::value::set) }

    val id: UUID = UUID.randomUUID()
    var children: List<Command<*>> by monitored(emptyList())

    suspend fun execute(board: GameBoard): ExecutionResult = this.action(board)
}

fun <T : Any> command(
    name: String,
    description: String = "~описание отсутствует~",
    removable: Boolean = true,
    availableNested: Boolean = false,
    initValue: T,
    fieldContent: @Composable (T, (T) -> Unit) -> Any = { _, _ -> },
    action: suspend Command<T>.(GameBoard) -> ExecutionResult
) = Command(
    name = name,
    description = description,
    availableNested = availableNested,
    removable = removable,
    initValue = initValue,
    action = action,
    fieldContent = fieldContent
)

interface CommandBoardManager {
    fun getBoard(): GameBoard
    fun setBoardFromExecutionResult(result: ExecutionResult, commandId: UUID)
}

object CommonCommands {
    fun start(boardManager: CommandBoardManager) = command<Unit>(
        "Начало",
        initValue = Unit,
        removable = false,
        availableNested = true
    ) {
        for (child in children) {
            Log.d("d", "from start: ${it.hero}")

            val childExecutionResult = child.execute(boardManager.getBoard())
            if (childExecutionResult !is ExecutionResult.Success) return@command childExecutionResult
            boardManager.setBoardFromExecutionResult(childExecutionResult, child.id)
            delay(1000)
        }
        return@command ExecutionResult.Success(boardManager.getBoard())
    }

    fun forCycle(boardManager: CommandBoardManager) =
        command<Int>(
            "Цикл", initValue = 0,
            availableNested = true,
            fieldContent = @Composable { state, setState ->
                TextField(
                    value = state.toString(),
                    onValueChange = { setState(it.toIntOrNull() ?: 0) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.width(100.dp),
                    singleLine = true
                )
            }
        ) {
            for (i in 0 until value) {
                children.forEach {
                    val childExecutionResult = it.execute(boardManager.getBoard())
                    if (childExecutionResult !is ExecutionResult.Success) return@forEach
                    boardManager.setBoardFromExecutionResult(childExecutionResult, it.id)
                    delay(1000)
                }
            }

            return@command ExecutionResult.Success(boardManager.getBoard())
        }

    fun moveRight(boardManager: CommandBoardManager) =
        command<Unit>("Шаг вправо", initValue = Unit) {
            ExecutionResult.Success(it.moveHero(1, 0))
        }

    fun moveLeft(boardManager: CommandBoardManager) =
        command<Unit>("Шаг влево", initValue = Unit) {
            ExecutionResult.Success(it.moveHero(-1, 0))
        }

    fun moveUp(boardManager: CommandBoardManager) =
        command<Unit>("Шаг вверх", initValue = Unit) {
            ExecutionResult.Success(it.moveHero(0, -1))
        }

    fun moveDown(boardManager: CommandBoardManager) =
        command<Unit>("Шаг вниз", initValue = Unit) {
            ExecutionResult.Success(it.moveHero(0, 1))
        }
}