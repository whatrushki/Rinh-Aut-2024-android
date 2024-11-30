package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

val WHATIcons.AlertOctagon: ImageVector
    get() {
        if (_AlertOctagon != null) {
            return _AlertOctagon!!
        }
        _AlertOctagon = ImageVector.Builder(
            name = "AlertOctagon",
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
                moveTo(7.86f, 2f)
                horizontalLineTo(16.14f)
                lineTo(22f, 7.86f)
                verticalLineTo(16.14f)
                lineTo(16.14f, 22f)
                horizontalLineTo(7.86f)
                lineTo(2f, 16.14f)
                verticalLineTo(7.86f)
                lineTo(7.86f, 2f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 8f)
                verticalLineTo(12f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 16f)
                horizontalLineTo(12.01f)
            }
        }.build()

        return _AlertOctagon!!
    }

@Suppress("ObjectPropertyName")
private var _AlertOctagon: ImageVector? = null
