package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.ArrowUpLeft: ImageVector
    get() {
        if (_ArrowUpLeft != null) {
            return _ArrowUpLeft!!
        }
        _ArrowUpLeft = ImageVector.Builder(
            name = "ArrowUpLeft",
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
                moveTo(17f, 17f)
                lineTo(7f, 7f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(7f, 17f)
                verticalLineTo(7f)
                horizontalLineTo(17f)
            }
        }.build()

        return _ArrowUpLeft!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowUpLeft: ImageVector? = null
