package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.Navigation2: ImageVector
    get() {
        if (_Navigation2 != null) {
            return _Navigation2!!
        }
        _Navigation2 = ImageVector.Builder(
            name = "Navigation2",
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
                moveTo(12f, 2f)
                lineTo(19f, 21f)
                lineTo(12f, 17f)
                lineTo(5f, 21f)
                lineTo(12f, 2f)
                close()
            }
        }.build()

        return _Navigation2!!
    }

@Suppress("ObjectPropertyName")
private var _Navigation2: ImageVector? = null
