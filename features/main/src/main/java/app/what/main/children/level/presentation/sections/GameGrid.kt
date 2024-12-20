package app.what.main.children.level.presentation.sections


import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import app.what.foundation.core.Listener
import app.what.main.children.level.domain.game.CellType
import app.what.main.children.level.domain.game.Point
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState

const val DefaultGameUnitSize = 20
const val DefaultGameGapWidth = 1

@Composable
fun GridForGame(
    state: LevelState,
    listener: Listener<LevelEvent>
) {
    val configuration = LocalConfiguration.current
    val maxWidth = with(LocalDensity.current) { LocalDensity.current.density.toInt() }
    val cellSize = remember {
        (configuration.screenWidthDp - state.board.grid.first().size.plus(3) * DefaultGameGapWidth) / state.board.grid.first().size
    }
    val cellSizePx = with(LocalDensity.current) { cellSize.dp.toPx() }
    val cellSpacingPx = with(LocalDensity.current) { DefaultGameGapWidth.dp.toPx() }
    val cellUnitEmojis = ""


    val grid = state.board.grid

    val heroUnitColor = Color.Green
    val defaultUnitColor = MaterialTheme.colorScheme.primaryContainer
    val specialUnitColor = MaterialTheme.colorScheme.primary
    val deadUnitColor = MaterialTheme.colorScheme.error

    val showDead = state.settings.showDead

    BoxWithConstraints {
        this
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .pointerInput(state, cellSize) {
                    detectTapGestures { offset ->
                        val gridWidth = grid.first().size * (cellSizePx + cellSpacingPx)
                        val gridHeight = grid.size * (cellSizePx + cellSpacingPx)

                        val offsetX = (size.width - gridWidth) / 2
                        val offsetY = (size.height - gridHeight) / 2

                        val x = ((offset.x - offsetX) / (cellSizePx + cellSpacingPx)).toInt()
                        val y = ((offset.y - offsetY) / (cellSizePx + cellSpacingPx)).toInt()

                        if (x in grid.first().indices && y in grid.indices) {
                            listener(LevelEvent.CellClicked(x, y))
                        }
                    }
                }
        ) {
            val gridWidth = grid.first().size * (cellSizePx + cellSpacingPx)
            val gridHeight = grid.size * (cellSizePx + cellSpacingPx)

            val offsetX = (size.width - gridWidth) / 2
            val offsetY = (size.height - gridHeight) / 2

            for (x in grid.first().indices) {
                for (y in grid.indices) {
                    val cell = state.board.grid[y][x]

                    val point = Point(x, y)
                    EmojiUnit(
                        unitColor = when {
                            point == state.board.hero.position -> heroUnitColor
                            point in state.board.exits -> heroUnitColor
                            point == state.board.start -> heroUnitColor
                            cell is CellType.Entity.Enemy && cell.defeated -> deadUnitColor
                            cell is CellType.Entity.Gem && !cell.hidden -> specialUnitColor
                            else -> defaultUnitColor
                        },
                        emoji = when {
                            point == state.board.hero.position -> state.settings.style.hero
                            point in state.board.exits -> state.settings.style.door
                            point == state.board.start -> state.settings.style.door
                            cell is CellType.Entity.Enemy && cell.defeated -> state.settings.style.enemyDefeated
                            cell is CellType.Entity.Enemy && !cell.hidden -> state.settings.style.enemy
                            cell is CellType.Entity.Gem && !cell.collected -> state.settings.style.gem
                            cell is CellType.Entity.Obstacle -> state.settings.style.obstacle
                            else -> ""
                        },
                        cellSizePx = cellSizePx,
                        cellSpacingPx = cellSpacingPx,
                        offsetX = offsetX,
                        x = x,
                        offsetY = offsetY,
                        y = y
                    )
                }
            }
        }
    }
}

private fun DrawScope.EmojiUnit(
    emoji: String,
    unitColor: Color,
    cellSizePx: Float,
    cellSpacingPx: Float,
    offsetX: Float,
    x: Int,
    offsetY: Float,
    y: Int
) {
    val textPaint = Paint().apply {
        color = Color.Black.toArgb()
        textSize = (cellSizePx - cellSpacingPx) * 0.65f
        textAlign = Paint.Align.CENTER
    }

    val offsetXCorrection = offsetX + x * (cellSizePx + cellSpacingPx) + cellSizePx / 2
    val offsetYCorrection = offsetY + y * (cellSizePx + cellSpacingPx) + cellSizePx / 2

    drawCircle(
        color = unitColor,
        center = Offset(
            offsetXCorrection,
            offsetYCorrection
        ),
        radius = (cellSizePx - cellSpacingPx) / 2
    )

    drawContext.canvas.nativeCanvas.drawText(
        emoji,
        offsetXCorrection,
        offsetYCorrection + (cellSizePx - cellSpacingPx) / 4,  // Коррекция по Y для центрирования текста
        textPaint
    )
}