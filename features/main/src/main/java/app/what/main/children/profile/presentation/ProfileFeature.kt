package app.what.main.children.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.foundation.core.Feature
import app.what.main.children.profile.domain.ProfileController
import app.what.main.children.profile.domain.models.ProfileEvent
import app.what.main.children.profile.navigation.ProfileProvider
import app.what.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileFeature(
    override val data: ProfileProvider
) : Feature<ProfileController, ProfileEvent>(),
    NavComponent<ProfileProvider>,
    KoinComponent {
    override val controller: ProfileController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(ProfileEvent.Init)
        }

        ProfileView(state, listener)
    }
}