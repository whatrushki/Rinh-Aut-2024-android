package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.StickyNote: ImageVector
    get() {
        if (_StickyNote != null) {
            return _StickyNote!!
        }
        _StickyNote = ImageVector.Builder(
            name = "StickyNote",
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
                moveTo(15.5f, 3f)
                horizontalLineTo(5f)
                curveTo(4.47f, 3f, 3.961f, 3.211f, 3.586f, 3.586f)
                curveTo(3.211f, 3.961f, 3f, 4.47f, 3f, 5f)
                verticalLineTo(19f)
                curveTo(3f, 20.1f, 3.9f, 21f, 5f, 21f)
                horizontalLineTo(19f)
                curveTo(19.53f, 21f, 20.039f, 20.789f, 20.414f, 20.414f)
                curveTo(20.789f, 20.039f, 21f, 19.53f, 21f, 19f)
                verticalLineTo(8.5f)
                lineTo(15.5f, 3f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15f, 3f)
                verticalLineTo(9f)
                horizontalLineTo(21f)
            }
        }.build()

        return _StickyNote!!
    }

@Suppress("ObjectPropertyName")
private var _StickyNote: ImageVector? = null
