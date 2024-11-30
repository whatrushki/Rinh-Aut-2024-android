package app.what.main.children.level.domain.models

import app.what.main.children.level.domain.game.GameBoard


data class LevelState(
    val board: GameBoard,
    val states: HashSet<GameBoard> = hashSetOf(),
    val settings: GameSettings = GameSettings(),
    val isSimulationRunning: Boolean = false,
    val gameResult: GameResult? = null
)

data class GameSettings(
    val scale: Float = 1f,
    val showDead: Boolean = false,
    val style: GameStyle = GameStyle.Default
)

sealed class GameResult {
    data object Finished : GameResult()
    data object Defeated : GameResult()
}

data class Command(
    val name: String,
)

sealed class GameStyle(
    val enemy: String,
    val enemyDefeated: String,
    val hero: String,
    val door: String,
    val obstacle: String,
    val gem: String
) {
    data object Default :
        GameStyle(
            "\uD83D\uDE08",
            "☁\uFE0F",
            "\uD83D\uDE0A",
            "\uD83C\uDF35",
            "\uD83E\uDDF1",
            "⭐\uFE0F"
        )
}

