package app.what.main.children.level.domain.models

sealed interface LevelEvent {
    data object Init : LevelEvent
    data class CellClicked(val x: Int, val y: Int) : LevelEvent

    data object StartSimulation : LevelEvent
    data object StopSimulation : LevelEvent
}