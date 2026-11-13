package Blind75.sliding.window

fun main() {
    val str = "zxyzxyz"
    println("Longest string ${lengthOfLongestSubstringBruteForce(str)}")
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
        while (set.contains(s[right])) {
            set.remove(s[left])
            left++
        }
        set.add(s[right])
        val currentLength = right - left + 1
        maxLength = maxOf(maxLength, currentLength)
    }

    return maxLength
}

fun lengthOfLongestSubstringBruteForce(s: String): Int {
    var maxlength = 0
    var n = s.length

    for(i in 0 until n) {
        val seen = HashSet<Char>()
        for(j in i until n) {
          val currentChar = s[j]
          if(seen.contains(currentChar)) {
             break;
          }
            seen.add(currentChar)
            maxlength = maxOf(maxlength, j-i+1)
        }
    }
    return maxlength

}
