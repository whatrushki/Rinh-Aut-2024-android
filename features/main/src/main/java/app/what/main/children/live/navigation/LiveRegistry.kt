package app.what.main.children.live.navigation

import app.what.main.children.live.presentation.LiveFeature
import app.what.navigation.core.NavProvider
import app.what.navigation.core.Registry
import app.what.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object LiveProvider : NavProvider()

val liveRegistry: Registry = {
    register(LiveFeature::class)
}