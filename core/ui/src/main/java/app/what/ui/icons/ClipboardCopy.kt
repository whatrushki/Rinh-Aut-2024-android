package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.ClipboardCopy: ImageVector
    get() {
        if (_ClipboardCopy != null) {
            return _ClipboardCopy!!
        }
        _ClipboardCopy = ImageVector.Builder(
            name = "ClipboardCopy",
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
                moveTo(15f, 2f)
                horizontalLineTo(9f)
                curveTo(8.448f, 2f, 8f, 2.448f, 8f, 3f)
                verticalLineTo(5f)
                curveTo(8f, 5.552f, 8.448f, 6f, 9f, 6f)
                horizontalLineTo(15f)
                curveTo(15.552f, 6f, 16f, 5.552f, 16f, 5f)
                verticalLineTo(3f)
                curveTo(16f, 2.448f, 15.552f, 2f, 15f, 2f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(8f, 4f)
                horizontalLineTo(6f)
                curveTo(5.47f, 4f, 4.961f, 4.211f, 4.586f, 4.586f)
                curveTo(4.211f, 4.961f, 4f, 5.47f, 4f, 6f)
                verticalLineTo(20f)
                curveTo(4f, 20.53f, 4.211f, 21.039f, 4.586f, 21.414f)
                curveTo(4.961f, 21.789f, 5.47f, 22f, 6f, 22f)
                horizontalLineTo(18f)
                curveTo(18.53f, 22f, 19.039f, 21.789f, 19.414f, 21.414f)
                curveTo(19.789f, 21.039f, 20f, 20.53f, 20f, 20f)
                verticalLineTo(18f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(16f, 4f)
                horizontalLineTo(18f)
                curveTo(18.53f, 4f, 19.039f, 4.211f, 19.414f, 4.586f)
                curveTo(19.789f, 4.961f, 20f, 5.47f, 20f, 6f)
                verticalLineTo(10f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(21f, 14f)
                horizontalLineTo(11f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15f, 10f)
                lineTo(11f, 14f)
                lineTo(15f, 18f)
            }
        }.build()

        return _ClipboardCopy!!
    }

@Suppress("ObjectPropertyName")
private var _ClipboardCopy: ImageVector? = null
