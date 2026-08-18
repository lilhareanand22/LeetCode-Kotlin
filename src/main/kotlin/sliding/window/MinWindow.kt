package sliding.window

fun minWindow(s: String, t: String): String {

    if (s.isEmpty() || t.isEmpty()) {
        return ""
    }

    // Characters we need
    val need = HashMap<Char, Int>()

    for (ch in t) {
        need[ch] = need.getOrDefault(ch, 0) + 1
    }

    // Characters inside current window
    val window = HashMap<Char, Int>()

    var left = 0
    var formed = 0
    val required = need.size

    var minLength = Int.MAX_VALUE
    var minStart = 0

    for (right in s.indices) {

        val ch = s[right]

        window[ch] = window.getOrDefault(ch, 0) + 1

        // Character has now satisfied its required frequency
        if (need.containsKey(ch) &&
            window[ch] == need[ch]
        ) {
            formed++
        }

        // Current window is valid
        while (left <= right && formed == required) {

            val windowLength = right - left + 1

            // Update smallest window
            if (windowLength < minLength) {
                minLength = windowLength
                minStart = left
            }

            val leftChar = s[left]

            window[leftChar] =
                window[leftChar]!! - 1

            // Window became invalid
            if (need.containsKey(leftChar) &&
                window[leftChar]!! < need[leftChar]!!
            ) {
                formed--
            }

            left++
        }
    }

    return if (minLength == Int.MAX_VALUE) {
        ""
    } else {
        s.substring(
            minStart,
            minStart + minLength
        )
    }
}

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    val minimumWindow = minWindow(s, t)
    println("Minimum window: $minimumWindow")
}