package app.what.main.children.level.domain

import android.util.Log
import app.what.foundation.core.UIController
import app.what.main.children.level.domain.game.GameBoard
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState
import com.chillrate.main.children.room.domain.models.LevelAction

class LevelController(board: GameBoard) : UIController<LevelState, LevelAction, LevelEvent>(
    LevelState(board)
) {
    override fun obtainEvent(viewEvent: LevelEvent) = when (viewEvent) {
        LevelEvent.Init -> {}
        is LevelEvent.CellClicked -> {}
        LevelEvent.MoveDown -> move(0, 1)
        LevelEvent.MoveLeft -> move(-1, 0)
        LevelEvent.MoveRight -> move(1, 0)
        LevelEvent.MoveUp -> move(0, -1)
    }

    fun move(x: Int, y: Int) {
        Log.d("d", "move $x $y")

        val board = viewState.board.moveHero(x, y)

        updateState {
            copy(
                board = board,
                gameResult = board.gameResult()
            )
        }
        Log.d("d", viewState.board.printBoard(viewState.board.hero))
    }


    fun init() {}

}