package sliding.window

fun main() {
    val str = "zxyzxyz"
    println("Longest string ${lengthOfLongestSubstring(str)}")
}

/**
 * Returns the length of the longest substring that contains no repeated characters.
 *
 * The set represents the current window, bounded by `left` and `right`. When a
 * duplicate enters it, move `left` forward until the window is valid.
 *
 * Time: O(n), Space: O(min(n, character set size)).
 */
fun lengthOfLongestSubstring(s: String): Int {

    val set = HashSet<Char>()

    var left = 0
    var maxLength = 0

    for (right in s.indices) {

        while (s[right] in set) {
            set.remove(s[left])
            left++
        }

        set.add(s[right])

        val currentLength = right - left + 1

        maxLength = maxOf(maxLength, currentLength)
    }

    return maxLength
}
