package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.ShieldClose: ImageVector
    get() {
        if (_ShieldClose != null) {
            return _ShieldClose!!
        }
        _ShieldClose = ImageVector.Builder(
            name = "ShieldClose",
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
                moveTo(12f, 22f)
                curveTo(12f, 22f, 20f, 18f, 20f, 12f)
                verticalLineTo(5f)
                lineTo(12f, 2f)
                lineTo(4f, 5f)
                verticalLineTo(12f)
                curveTo(4f, 18f, 12f, 22f, 12f, 22f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(9.5f, 9f)
                lineTo(14.5f, 14f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(14.5f, 9f)
                lineTo(9.5f, 14f)
            }
        }.build()

        return _ShieldClose!!
    }

@Suppress("ObjectPropertyName")
private var _ShieldClose: ImageVector? = null
