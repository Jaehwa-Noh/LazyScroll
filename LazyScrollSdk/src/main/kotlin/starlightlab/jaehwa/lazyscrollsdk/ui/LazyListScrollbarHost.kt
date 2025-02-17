package starlightlab.jaehwa.lazyscrollsdk.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import starlightlab.jaehwa.lazyscrollsdk.scrollbar.LazyListScrollbarScreen

/**
 * This Host contains [LazyListScrollbarScreen] and [content].
 * It overlay scrollbar over the lazy composable content.
 * It took over the [lazyListState] at content for sharing [lazyListState].
 *
 * @param lazyListState LazyListState for sharing state with [content] and [LazyListScrollbarScreen] both.
 * @param content This will be lazy composable: [LazyColumn] or [LazyRow].
 * @param modifier Modify [LazyListScrollbarHost].
 */
@Composable
fun LazyListScrollbarHost(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
    content: @Composable (LazyListState) -> Unit,
) {
    Box(modifier = modifier) {
        content(lazyListState)
        LazyListScrollbarScreen(lazyListState = lazyListState)
    }

}
