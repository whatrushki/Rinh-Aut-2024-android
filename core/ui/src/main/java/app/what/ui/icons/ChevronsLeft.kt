package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.ChevronsLeft: ImageVector
    get() {
        if (_ChevronsLeft != null) {
            return _ChevronsLeft!!
        }
        _ChevronsLeft = ImageVector.Builder(
            name = "ChevronsLeft",
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
                moveTo(11f, 17f)
                lineTo(6f, 12f)
                lineTo(11f, 7f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18f, 17f)
                lineTo(13f, 12f)
                lineTo(18f, 7f)
            }
        }.build()

        return _ChevronsLeft!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronsLeft: ImageVector? = null
