package app.what.main.children.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.what.foundation.core.Listener
import app.what.main.children.profile.domain.models.ProfileEvent
import app.what.main.children.profile.domain.models.ProfileState

@Composable
fun ProfileView(
    state: ProfileState,
    listener: Listener<ProfileEvent>
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()
) {

}