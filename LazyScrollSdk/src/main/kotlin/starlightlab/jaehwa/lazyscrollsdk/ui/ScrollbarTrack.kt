package starlightlab.jaehwa.lazyscrollsdk.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind

/**
 * Track for scrollbar
 *
 * @param modifier modify this screen.
 */
@Composable
fun ScrollbarTrack(
    modifier: Modifier = Modifier,
) {
    val trackColor = MaterialTheme.colorScheme.surfaceVariant

    Box(
        modifier
            .fillMaxSize()
            .drawBehind {
                drawRect(
                    trackColor,
                    alpha = 0.6f,
                )
            }
    )
}
