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

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.test.assertPositionInRootIsEqualTo
import androidx.compose.ui.test.assertTopPositionInRootIsEqualTo
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeUp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test
import starlightlab.jaehwa.lazyscroll.testtags.LAZY_LIST_STATE_TEST_TAG
import starlightlab.jaehwa.lazyscroll.testtags.THUMB_TEST_TAG
import starlightlab.jaehwa.lazyscroll.ui.theme.LazyScrollTheme

class ScrollbarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun vertical_waitUntilInvisible_invisible() {
        composeTestRule.setContent {
            LazyScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenForTesting(
                        orientation = Orientation.Vertical,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }

        val thumbComponent = composeTestRule.onNodeWithTag(THUMB_TEST_TAG)
        thumbComponent.isDisplayed()
        composeTestRule.waitUntil(5_000L) {
            thumbComponent.isNotDisplayed()
        }
    }

    @Test
    fun vertical_swipeUpTillEnd_thumbEnd() {
        composeTestRule.setContent {
            LazyScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenForTesting(
                        orientation = Orientation.Vertical,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }


        val lazyListComponent = composeTestRule.onNodeWithTag(LAZY_LIST_STATE_TEST_TAG)

        val thumbComponent = composeTestRule.onNodeWithTag(THUMB_TEST_TAG)

        lazyListComponent
            .performTouchInput {
                swipe(Offset(centerX, bottom), Offset(centerX, top), 100)
            }

        composeTestRule.waitUntil(5_000L) {
            thumbComponent.isDisplayed()
        }

        composeTestRule.waitUntil(5_000L) {
            thumbComponent.isNotDisplayed()
        }

        composeTestRule.waitUntil(5_000L) {
            composeTestRule.onNodeWithText("100").isDisplayed()
        }
    }

    @Test
    fun vertical_dragTillDown_showLastItem() {
        composeTestRule.setContent {
            LazyScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenForTesting(
                        orientation = Orientation.Vertical,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }

        val lazyListComponent = composeTestRule.onNodeWithTag(LAZY_LIST_STATE_TEST_TAG)
        val thumbComponent = composeTestRule.onNodeWithTag(THUMB_TEST_TAG)
        var scrollHeight: Int = 0
        lazyListComponent
            .performTouchInput {
                swipe(Offset(centerX, bottom), Offset(centerX, bottom - 50), 5_000L)
                scrollHeight = height
            }

        composeTestRule.waitUntil(5_000L) {
            thumbComponent.isDisplayed()
        }

        try {
            repeat(1000) {
                thumbComponent.performTouchInput {
                    swipe(Offset(centerX, centerY), Offset(centerX, (centerY - 1000f)), 1000)
                    advanceEventTime(1000L)
                }
            }
        } catch (_: AssertionError) {
            // Reached at bottom.
        }

        composeTestRule.waitUntil(5_000L) {
            composeTestRule.onNodeWithText("100").isDisplayed()
        }
    }
}
