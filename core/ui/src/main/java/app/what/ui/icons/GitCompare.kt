package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.GitCompare: ImageVector
    get() {
        if (_GitCompare != null) {
            return _GitCompare!!
        }
        _GitCompare = ImageVector.Builder(
            name = "GitCompare",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18f, 21f)
                curveTo(19.657f, 21f, 21f, 19.657f, 21f, 18f)
                curveTo(21f, 16.343f, 19.657f, 15f, 18f, 15f)
                curveTo(16.343f, 15f, 15f, 16.343f, 15f, 18f)
                curveTo(15f, 19.657f, 16.343f, 21f, 18f, 21f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(6f, 9f)
                curveTo(7.657f, 9f, 9f, 7.657f, 9f, 6f)
                curveTo(9f, 4.343f, 7.657f, 3f, 6f, 3f)
                curveTo(4.343f, 3f, 3f, 4.343f, 3f, 6f)
                curveTo(3f, 7.657f, 4.343f, 9f, 6f, 9f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(13f, 6f)
                horizontalLineTo(16f)
                curveTo(16.53f, 6f, 17.039f, 6.211f, 17.414f, 6.586f)
                curveTo(17.789f, 6.961f, 18f, 7.47f, 18f, 8f)
                verticalLineTo(15f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(11f, 18f)
                horizontalLineTo(8f)
                curveTo(7.47f, 18f, 6.961f, 17.789f, 6.586f, 17.414f)
                curveTo(6.211f, 17.039f, 6f, 16.53f, 6f, 16f)
                verticalLineTo(9f)
            }
        }.build()

        return _GitCompare!!
    }

@Suppress("ObjectPropertyName")
private var _GitCompare: ImageVector? = null
