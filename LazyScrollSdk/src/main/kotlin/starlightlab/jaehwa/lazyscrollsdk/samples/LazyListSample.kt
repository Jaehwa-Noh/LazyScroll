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
                        modifier = Modifier.padding(16.dp)
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
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}