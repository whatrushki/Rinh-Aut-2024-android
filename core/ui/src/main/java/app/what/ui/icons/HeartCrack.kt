package app.what.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WHATIcons.HeartCrack: ImageVector
    get() {
        if (_HeartCrack != null) {
            return _HeartCrack!!
        }
        _HeartCrack = ImageVector.Builder(
            name = "HeartCrack",
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
                moveTo(20.42f, 4.58f)
                curveTo(19.918f, 4.077f, 19.322f, 3.677f, 18.666f, 3.405f)
                curveTo(18.009f, 3.132f, 17.306f, 2.992f, 16.595f, 2.992f)
                curveTo(15.884f, 2.992f, 15.181f, 3.132f, 14.524f, 3.405f)
                curveTo(13.868f, 3.677f, 13.272f, 4.077f, 12.77f, 4.58f)
                lineTo(12f, 5.36f)
                lineTo(11.23f, 4.58f)
                curveTo(10.728f, 4.077f, 10.132f, 3.677f, 9.476f, 3.405f)
                curveTo(8.819f, 3.132f, 8.116f, 2.992f, 7.405f, 2.992f)
                curveTo(6.694f, 2.992f, 5.991f, 3.132f, 5.334f, 3.405f)
                curveTo(4.678f, 3.677f, 4.082f, 4.077f, 3.58f, 4.58f)
                curveTo(1.46f, 6.7f, 1.33f, 10.28f, 4f, 13f)
                lineTo(12f, 21f)
                lineTo(20f, 13f)
                curveTo(22.67f, 10.28f, 22.54f, 6.7f, 20.42f, 4.58f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 13f)
                lineTo(11f, 12f)
                lineTo(13f, 10f)
                lineTo(10f, 7.5f)
                lineTo(12.77f, 4.58f)
            }
        }.build()

        return _HeartCrack!!
    }

@Suppress("ObjectPropertyName")
private var _HeartCrack: ImageVector? = null
