package sliding.window


fun main() {
    val str = "zxyzxyz"
    println("Longest string ${lengthOfLongestSubstring(str)}")
}

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