package app.what.main.children.profile.navigation

import app.what.navigation.core.NavProvider
import app.what.navigation.core.Registry
import app.what.navigation.core.register
import app.what.main.children.profile.presentation.ProfileFeature
import kotlinx.serialization.Serializable

@Serializable
object ProfileProvider : NavProvider()

val profileRegistry: Registry = {
    register(ProfileFeature::class)
}