package app.what.main.children.level.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.foundation.core.Feature
import app.what.main.children.level.domain.LevelController
import app.what.main.children.level.domain.game.LevelRef
import app.what.main.children.level.domain.game.Point
import app.what.main.children.level.domain.game.gameBoard
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.navigation.LevelProvider
import app.what.navigation.core.NavComponent
import org.koin.core.component.KoinComponent

class LevelFeature(
    override val data: LevelProvider
) : Feature<LevelController, LevelEvent>(),
    NavComponent<LevelProvider>,
    KoinComponent {
    private val board = gameBoard {
        size(5, 6)
        start(0, 0)
        hero(2, 2)
        gem(Point(2, 2))
        gem(Point(2, 4))
        gem(Point(4, 4))
        obstacle(Point(4, 0), damage = 2)
        obstacle(Point(0, 1), damage = 2)
        obstacle(Point(2, 1), damage = 2)
        obstacle(Point(3, 2), damage = 2)
        obstacle(Point(3, 4), damage = 2)
        obstacle(Point(1, 3), damage = 2)
        obstacle(Point(2, 3), damage = 2)
        enemy(Point(4, 2), attack = 1, hp = 3, hidden = true)
        enemy(Point(1, 4), attack = 1, hp = 3, hidden = true)
        enemy(Point(5, 4), attack = 1, hp = 3, hidden = true)

        exits {
            this[Point(3, 3)] = LevelRef(7, 1)
            this[Point(5, 0)] = LevelRef(7, 3)
        }
    }

    override val controller: LevelController = LevelController(board)

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(LevelEvent.Init)
        }

        LevelView(state, listener)

        when (action) {
            else -> {}
        }
    }
}