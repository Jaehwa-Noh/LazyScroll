/*
    Copyright 2025 Jaehwa Noh

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
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
 *
 * @sample starlightlab.jaehwa.lazyscrollsdk.samples.LazyColumnSample
 * @sample starlightlab.jaehwa.lazyscrollsdk.samples.LazyRowSample
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
