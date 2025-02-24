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
package starlightlab.jaehwa.lazyscrollsdk.extensions

internal fun IntArray.sumRange(
    start: Int = 0,
    until: Int,
): Int {
    if (this.isEmpty()) {
        return 0
    }
    var sum = 0
    for (i in start..until) {
        sum += this[i]
    }
    return sum
}
