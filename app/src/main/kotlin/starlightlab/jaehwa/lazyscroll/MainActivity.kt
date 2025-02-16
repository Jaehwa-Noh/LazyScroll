package starlightlab.jaehwa.lazyscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import starlightlab.jaehwa.lazyscroll.ui.theme.LazyScrollTheme
import starlightlab.jaehwa.lazyscrollsdk.ui.LazyListScrollbarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenForTesting(
                        orientation = Orientation.Horizontal,
                        modifier = Modifier.padding(innerPadding)
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
    val lazyListState = rememberLazyListState()
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (orientation == Orientation.Vertical) {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxWidth(),
            ) {
                createItems()
            }
            LazyListScrollbarScreen(lazyListState = lazyListState)
        } else {
            LazyRow(
                state = lazyListState,
                modifier = Modifier.fillMaxHeight(),
            ) {
                createItems()
            }
            LazyListScrollbarScreen(lazyListState = lazyListState)
        }
    }
}


private fun LazyListScope.createItems() {
    for (i in 0..100) {
        item {
            Text("$i")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyScrollbarVerticalPreview() {
    LazyScrollTheme {
        ScreenForTesting(
            orientation = Orientation.Vertical
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LazyScrollbarHorizontalPreview() {
    LazyScrollTheme {
        ScreenForTesting(
            orientation = Orientation.Horizontal
        )
    }
}
