package app.what.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.foundation.core.Feature
import app.what.main.children.level.navigation.LevelProvider
import app.what.main.children.level.navigation.levelRegistry
import app.what.main.children.live.navigation.LiveProvider
import app.what.main.children.live.navigation.liveRegistry
import app.what.main.children.profile.navigation.ProfileProvider
import app.what.main.children.profile.navigation.profileRegistry
import app.what.main.domain.MainController
import app.what.main.domain.models.MainEvent
import app.what.main.navigation.MainProvider
import app.what.navigation.bottom_navigation.navItem
import app.what.navigation.core.NavComponent
import app.what.navigation.core.Registry
import app.what.ui.icons.List
import app.what.ui.icons.WHATIcons
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainFeature(
    override val data: MainProvider
) : Feature<MainController, MainEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {
    override val controller: MainController by inject()

    internal companion object {
        val children: Registry = {
            profileRegistry()
            liveRegistry()
            levelRegistry()
        }

        val navList = listOf(
            navItem(
                name = "Главная",
                icon = WHATIcons.List,
                provider = LiveProvider
            ),
            navItem(
                name = "Комната",
                icon = WHATIcons.List,
                provider = LevelProvider
            ),
            navItem(
                name = "Профиль",
                icon = WHATIcons.List,
                provider = ProfileProvider
            )
        )
    }

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(MainEvent.Init)
        }

        MainView(state, listener)

        when (action) {
            else -> {}
        }
    }
}