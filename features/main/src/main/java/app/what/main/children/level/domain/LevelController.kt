package app.what.main.children.level.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.what.foundation.core.UIController
import app.what.foundation.utils.doAfter
import app.what.main.children.level.domain.game.CellType
import app.what.main.children.level.domain.game.CommandBoardManager
import app.what.main.children.level.domain.game.CommonCommands
import app.what.main.children.level.domain.game.ExecutionResult
import app.what.main.children.level.domain.game.GameBoard
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState
import com.chillrate.main.children.room.domain.models.LevelAction
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID

class LevelController(
    board: GameBoard
) : UIController<LevelState, LevelAction, LevelEvent>(
    LevelState(board)
) {

    private val commandBoardManager = object : CommandBoardManager {
        override fun getBoard(): GameBoard = viewState.board

        override fun setBoardFromExecutionResult(
            result: ExecutionResult,
            commandId: UUID
        ) {
            when (result) {
                is ExecutionResult.Failure -> {}
                is ExecutionResult.Success -> updateState {
                    val gameResult = result.board.gameResult()
                    if (gameResult != null) doAfter(500) {
                        stopSimulation()
                    }

                    copy(
                        board = result.board,
                        currentCommandId = commandId
                    )
                }
            }
        }
    }

    private fun GameBoard.clone(): GameBoard = this.copy(
        hero = hero.copy(position = start),
        grid = grid.map {
            it.map {
                when (it) {
                    is CellType.Empty -> CellType.Empty;
                    is CellType.Entity.Enemy -> it.copy()
                    is CellType.Entity.Gem -> it.copy()
                    is CellType.Entity.Obstacle -> it
                }
            }.toTypedArray().clone().toList()
        }.toTypedArray().clone().toList()
    )

    private val rememberInitialBoard = board.apply {
        availableCommands = availableCommandsBuilder(commandBoardManager)
    }.clone()

    private fun getRememberedInitialBoard() = rememberInitialBoard.apply {
        Log.d("d", "getRememberedInitialBoard")
        availableCommands = availableCommandsBuilder(commandBoardManager)
        Log.d("d", "avvailable commands updated: ${availableCommands}")
    }.clone()

    private var simulationJob: Job? = null

    override fun obtainEvent(viewEvent: LevelEvent) = when (viewEvent) {
        LevelEvent.Init -> init()
        is LevelEvent.CellClicked -> {}
        LevelEvent.StartSimulation -> startSimulation()
        LevelEvent.StopSimulation -> stopSimulation()
    }

    fun init() {
        val baseCommands = listOf(
            CommonCommands.moveRight(commandBoardManager).copy(),
            CommonCommands.moveRight(commandBoardManager).copy(),
            CommonCommands.moveRight(commandBoardManager).copy(),
            CommonCommands.moveDown(commandBoardManager).copy(),
            CommonCommands.moveRight(commandBoardManager).copy(),
            CommonCommands.moveDown(commandBoardManager).copy(),
            CommonCommands.moveDown(commandBoardManager).copy(),
        )

        val commandRoot = CommonCommands.start(commandBoardManager)
            .apply { children = baseCommands }

        updateState {
            board.availableCommands = board.availableCommandsBuilder(commandBoardManager)
            copy(commandRoot = commandRoot)
        }
    }

    private fun startSimulation() {
        Log.d("d", "start simulation")
        Log.d("d", "prepare previous")
        stopSimulation()

        simulationJob = viewModelScope.launch {
            Log.d("d", "job started")
            safeUpdateState {
                board.availableCommands = board.availableCommandsBuilder(commandBoardManager)
                copy(
                    board = getRememberedInitialBoard(),
                    isSimulationRunning = true
                )
            }

            Log.d("d", "board cleared")

            delay(1000)

            Log.d("d", "executing start comand")
            viewState.commandRoot?.execute(viewState.board)

            stopSimulation()
            Log.d("d", "state updated")
        }
    }

    private fun stopSimulation() {
        Log.d("d", "stop simulation")
        simulationJob?.cancel()
        simulationJob = null

        updateState {
            board.availableCommands = board.availableCommandsBuilder(commandBoardManager)
            copy(
                isSimulationRunning = false,
                currentCommandId = null
            )
        }
        Log.d("d", "stop simulation state updated")
    }
}