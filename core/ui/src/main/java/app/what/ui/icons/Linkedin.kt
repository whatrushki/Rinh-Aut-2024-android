package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

val WHATIcons.Linkedin: ImageVector
    get() {
        if (_Linkedin != null) {
            return _Linkedin!!
        }
        _Linkedin = ImageVector.Builder(
            name = "Linkedin",
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
                moveTo(16f, 8f)
                curveTo(17.591f, 8f, 19.117f, 8.632f, 20.243f, 9.757f)
                curveTo(21.368f, 10.883f, 22f, 12.409f, 22f, 14f)
                verticalLineTo(21f)
                horizontalLineTo(18f)
                verticalLineTo(14f)
                curveTo(18f, 13.47f, 17.789f, 12.961f, 17.414f, 12.586f)
                curveTo(17.039f, 12.211f, 16.53f, 12f, 16f, 12f)
                curveTo(15.47f, 12f, 14.961f, 12.211f, 14.586f, 12.586f)
                curveTo(14.211f, 12.961f, 14f, 13.47f, 14f, 14f)
                verticalLineTo(21f)
                horizontalLineTo(10f)
                verticalLineTo(14f)
                curveTo(10f, 12.409f, 10.632f, 10.883f, 11.757f, 9.757f)
                curveTo(12.883f, 8.632f, 14.409f, 8f, 16f, 8f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(6f, 9f)
                horizontalLineTo(2f)
                verticalLineTo(21f)
                horizontalLineTo(6f)
                verticalLineTo(9f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4f, 6f)
                curveTo(5.105f, 6f, 6f, 5.105f, 6f, 4f)
                curveTo(6f, 2.895f, 5.105f, 2f, 4f, 2f)
                curveTo(2.895f, 2f, 2f, 2.895f, 2f, 4f)
                curveTo(2f, 5.105f, 2.895f, 6f, 4f, 6f)
                close()
            }
        }.build()

        return _Linkedin!!
    }

@Suppress("ObjectPropertyName")
private var _Linkedin: ImageVector? = null
