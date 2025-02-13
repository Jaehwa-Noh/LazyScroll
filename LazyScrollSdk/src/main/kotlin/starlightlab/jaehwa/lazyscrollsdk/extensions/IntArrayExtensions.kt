package starlightlab.jaehwa.lazyscrollsdk.extensions

internal fun IntArray.sumRange(start: Int = 0, until: Int): Int {
    if (this.isEmpty()) {
        return 0
    }
    var sum = 0
    for (i in start..until) {
        sum += this[i]
    }
    return sum
}
