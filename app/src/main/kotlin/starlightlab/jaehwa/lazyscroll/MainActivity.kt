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
package starlightlab.jaehwa.lazyscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import starlightlab.jaehwa.lazyscroll.testtags.LAZY_LIST_STATE_TEST_TAG
import starlightlab.jaehwa.lazyscroll.ui.theme.LazyScrollTheme
import starlightlab.jaehwa.lazyscrollsdk.ui.LazyListScrollbarHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenForTesting(
                        orientation = Orientation.Vertical,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenForTesting(
    orientation: Orientation,
    modifier: Modifier = Modifier,
) {
    LazyListScrollbarHost(
        modifier =
            modifier
                .windowInsetsPadding(WindowInsets.safeDrawing),
    ) { lazyListState ->
        if (orientation == Orientation.Vertical) {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier
                    .testTag(LAZY_LIST_STATE_TEST_TAG)
                    .fillMaxWidth(),
            ) {
                createItems()
            }
        } else {
            LazyRow(
                state = lazyListState,
                modifier = Modifier
                    .testTag(LAZY_LIST_STATE_TEST_TAG)
                    .fillMaxHeight(),
            ) {
                createItems()
            }
        }
    }
}

private fun LazyListScope.createItems() {
    for (i in 0..100) {
        item {
            Text(
                "$i",
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyScrollbarVerticalPreview() {
    LazyScrollTheme {
        ScreenForTesting(
            orientation = Orientation.Vertical,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LazyScrollbarHorizontalPreview() {
    LazyScrollTheme {
        ScreenForTesting(
            orientation = Orientation.Horizontal,
        )
    }
}
