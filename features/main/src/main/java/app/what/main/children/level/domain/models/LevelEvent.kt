package app.what.main.children.level.domain.models

sealed interface LevelEvent {
    data object Init : LevelEvent
    data class CellClicked(val x: Int, val y: Int) : LevelEvent

    data object MoveRight : LevelEvent
    data object MoveUp : LevelEvent
    data object MoveDown : LevelEvent
    data object MoveLeft : LevelEvent
}