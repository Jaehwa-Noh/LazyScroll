package starlightlab.jaehwa.lazyscrollsdk.ui

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

/**
 * Actual Thumb
 *
 * @param size size of a thumb
 * @param offset offset of thumb in the screen.
 * @param viewportSize lazy composable screen size.
 * @param orientation orientation of a lazy composable scroll direction
 * @param onDrag catch a drag action.
 * @param modifier modify this screen.
 */
@Composable
internal fun ScrollbarThumb(
    size: Float,
    offset: Float,
    viewportSize: Int,
    orientation: Orientation,
    onDrag: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {

    val trackThumbColor = MaterialTheme.colorScheme.primary
    val thumbSizePx = with(LocalDensity.current) { size.dp.toPx() }
    Box(
        modifier = modifier
            .graphicsLayer {
                val offsetFloat = when {
                    offset <= 0f -> 0f
                    offset > 0f && offset < viewportSize - thumbSizePx -> offset
                    offset >= viewportSize - thumbSizePx -> viewportSize - thumbSizePx
                    else -> Float.NaN
                }

                if (orientation == Orientation.Vertical) translationY =
                    offsetFloat else translationX = offsetFloat
            }
            .fillMaxWidth()
            .height(height.dp)
            .drawBehind {
                drawRoundRect(
                    trackThumbColor,
                    cornerRadius = CornerRadius(24f)
                )
            }
            .draggable(
                orientation = orientation,
                state = rememberDraggableState(onDrag)
            ),
        )
}
