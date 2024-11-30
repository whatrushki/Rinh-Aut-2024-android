package app.what.main.children.profile.domain

import app.what.foundation.core.UIController
import app.what.main.children.profile.domain.models.ProfileAction
import app.what.main.children.profile.domain.models.ProfileEvent
import app.what.main.children.profile.domain.models.ProfileState

class ProfileController : UIController<ProfileState, ProfileAction, ProfileEvent>(
    ProfileState()
) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            ProfileEvent.Init -> {}
        }
    }
}