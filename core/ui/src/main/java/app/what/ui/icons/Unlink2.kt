package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.Unlink2: ImageVector
    get() {
        if (_Unlink2 != null) {
            return _Unlink2!!
        }
        _Unlink2 = ImageVector.Builder(
            name = "Unlink2",
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
                moveTo(15f, 7f)
                horizontalLineTo(17f)
                curveTo(18.326f, 7f, 19.598f, 7.527f, 20.535f, 8.464f)
                curveTo(21.473f, 9.402f, 22f, 10.674f, 22f, 12f)
                curveTo(22f, 13.326f, 21.473f, 14.598f, 20.535f, 15.535f)
                curveTo(19.598f, 16.473f, 18.326f, 17f, 17f, 17f)
                horizontalLineTo(15f)
                moveTo(9f, 17f)
                horizontalLineTo(7f)
                curveTo(5.674f, 17f, 4.402f, 16.473f, 3.464f, 15.535f)
                curveTo(2.527f, 14.598f, 2f, 13.326f, 2f, 12f)
                curveTo(2f, 10.674f, 2.527f, 9.402f, 3.464f, 8.464f)
                curveTo(4.402f, 7.527f, 5.674f, 7f, 7f, 7f)
                horizontalLineTo(9f)
            }
        }.build()

        return _Unlink2!!
    }

@Suppress("ObjectPropertyName")
private var _Unlink2: ImageVector? = null
