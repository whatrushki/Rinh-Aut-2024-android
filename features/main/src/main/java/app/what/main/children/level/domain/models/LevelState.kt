package app.what.main.children.level.domain.models

import app.what.main.children.level.domain.game.Command
import app.what.main.children.level.domain.game.GameBoard
import java.util.UUID


data class LevelState(
    val board: GameBoard,
    val states: HashSet<GameBoard> = hashSetOf(),
    val settings: GameSettings = GameSettings(),
    val isSimulationRunning: Boolean = false,
    val commandRoot: Command<*>? = null,
    val gameResult: GameResult? = null,
    val currentCommandId: UUID? = null
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
            "\uD83E\uDEE7",
            "\uD83D\uDE0A",
            "\uD83D\uDEAA",
            "\uD83E\uDDF1",
            "⭐️\uFE0F"
        )

    data object Forest :
        GameStyle(
            "\uD83D\uDC3A",
            "\uD83E\uDEE7",
            "\uD83E\uDDDD\u200D♀\uFE0F",
            "\uD83D\uDEAA",
            "\uD83C\uDF33",
            "\uD83E\uDED0"
        )


    data object Desert :
        GameStyle(
            "\uD83E\uDD82",
            "\uD83E\uDEE7",
            "\uD83E\uDD20",
            "\uD83D\uDEAA",
            "\uD83C\uDF35",
            "\uD83E\uDEDA"
        )

    data object Oceania :
        GameStyle(
            "\uD83E\uDD88",
            "\uD83E\uDEE7",
            "\uD83E\uDDDC\u200D♀\uFE0F",
            "\uD83D\uDEAA",
            "\uD83C\uDF0A",
            "\uD83E\uDD80"
        )

    data object Mountain :
        GameStyle(
            "\uD83D\uDC3B",
            "\uD83E\uDEE7",
            "\uD83E\uDDD7\u200D",
            "\uD83D\uDEAA",
            "\uD83E\uDEA8",
            "\uD83C\uDF52"
        )

    data object Sky :
        GameStyle(
            "\uD83D\uDC32",
            "\uD83E\uDEE7",
            "\uD83E\uDD80",
            "\uD83D\uDEAA",
            "☁️\uFE0F",
            "\uD83C\uDF47"
        )

    data object Space :
        GameStyle(
            "\uD83D\uDC7E",
            "\uD83E\uDEE7",
            "\uD83D\uDC68\u200D\uD83D\uDE80",
            "\uD83D\uDEAA",
            "☄️\uFE0F",
            "\uD83D\uDC8E"
        )

    data object Snow :
        GameStyle(
            "⛄️\uFE0F",
            "\uD83E\uDEE7",
            "\uD83E\uDDD6\uD83C\uDFFB\u200D♀\uFE0F",
            "\uD83D\uDEAA",
            "❄️\uFE0F",
            "\uD83C\uDF66"
        )

    data object Armenia :
        GameStyle(
            "\uD83D\uDC10",
            "\uD83E\uDEE7",
            "\uD83E\uDD78",
            "\uD83D\uDEAA",
            "\uD83D\uDDFB",
            "\uD83C\uDF47"
        )

}
