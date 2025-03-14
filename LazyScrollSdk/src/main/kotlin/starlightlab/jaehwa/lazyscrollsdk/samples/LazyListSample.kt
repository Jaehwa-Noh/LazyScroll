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
package starlightlab.jaehwa.lazyscrollsdk.samples

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import starlightlab.jaehwa.lazyscrollsdk.ui.LazyListScrollbarHost

@Composable
internal fun LazyColumnSample() {
    LazyListScrollbarHost { lazyListState ->
        LazyColumn(state = lazyListState) {
            repeat(100) {
                item {
                    Text(
                        "Hello, $it",
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}

@Composable
internal fun LazyRowSample() {
    LazyListScrollbarHost { lazyListState ->
        LazyRow(state = lazyListState) {
            repeat(100) {
                item {
                    Text(
                        "Hello, $it",
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}
