package starlightlab.jaehwa.lazyscrollsdk.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import starlightlab.jaehwa.lazyscrollsdk.scrollbar.LazyListScrollbarScreen

@Composable
fun LazyListScrollbarHost(
    lazyListState: LazyListState = rememberLazyListState(),
    modifier: Modifier = Modifier,
    content: @Composable (LazyListState) -> Unit,
) {
    Box(modifier = modifier) {
        content(lazyListState)
        LazyListScrollbarScreen(lazyListState = lazyListState)
    }

}
