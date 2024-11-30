package app.what.main.children.level.navigation

import app.what.main.children.level.presentation.LevelFeature
import app.what.navigation.core.NavProvider
import app.what.navigation.core.Registry
import app.what.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object LevelProvider : NavProvider()

val levelRegistry: Registry = {
    register(LevelFeature::class)
}