package app.what.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColor = compositionLocalOf { Color.White }
val LocalTypography = staticCompositionLocalOf { Typography() }
val LocalPalette = staticCompositionLocalOf { Color.White }
val LocalSpacing = compositionLocalOf { Spacing.Common }

data class Spacing(
    val none: Int,
    val xs: Int,
    val sm: Int,
    val md: Int,
    val lg: Int,
    val xl: Int
) {
    companion object Defaults {
        val Common = Spacing(
            none = 0,
            xs = 4,
            sm = 8,
            md = 16,
            lg = 24,
            xl = 32
        )
    }
}

object CadetTheme {
    val colors: Color
        @Composable get() = LocalColor.current

    val palettes: Color
        @Composable get() = LocalPalette.current

    val spacing: Spacing
        @Composable get() = LocalSpacing.current

    val typography: Typography
        @Composable get() = LocalTypography.current
}