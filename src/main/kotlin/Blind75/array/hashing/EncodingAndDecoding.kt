package Blind75.array.hashing

fun main() {
    val codec = Codec()
    val words = listOf("hello", "world", "", "kotlin#rocks")

    val encoded = codec.encode(words)
    val decoded = codec.decode(encoded)

    println("Original: $words")
    println("Encoded: $encoded")
    println("Decoded: $decoded")
}

class Codec {

    fun encode(strs: List<String>): String {
        val result = StringBuilder()

        for (str in strs) {
            result.append(str.length)
            result.append("#")
            result.append(str)
        }

        return result.toString()
    }

    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < s.length) {

            // Find '#'
            var j = i

            while (s[j] != '#') {
                j++
            }

            // Extract length
            val length = s.substring(i, j).toInt()

            // Move after '#'
            j++

            // Extract actual string
            val str = s.substring(j, j + length)

            result.add(str)

            // Move to next encoded string
            i = j + length
        }

        return result
    }
}
