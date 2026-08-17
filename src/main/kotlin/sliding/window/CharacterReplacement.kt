package sliding.window



fun characterReplacement(s: String, k: Int): Int {
    val frequency = IntArray(26)
    var left = 0
    var maxLength = 0
    var maxFrequency = 0
    for(right in s.indices) {
        val index = s[right] - 'A'
        frequency[index]++
        maxFrequency = maxOf(maxFrequency,
            frequency[index])
        val windowSize = right - left + 1
        val replacementsNeed = windowSize - maxFrequency
        if(replacementsNeed > k) {
            frequency[s[left] - 'A'] --
            left ++
        }
       maxLength = maxOf(maxLength,
                 right - left + 1)

    }
return maxLength
}

fun main() {
    val s = "AABABBA"
    val k = 1
    val longestLength = characterReplacement(s, k)

    println("Input: s = $s, k = $k")
    println("Longest repeating character replacement length: $longestLength")
}
