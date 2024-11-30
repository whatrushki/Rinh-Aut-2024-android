package app.what.main.navigation

import app.what.main.presentation.MainFeature
import app.what.navigation.core.NavProvider
import app.what.navigation.core.Registry
import app.what.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object MainProvider : NavProvider()

val mainRegistry: Registry = {
    register(MainFeature::class)
}