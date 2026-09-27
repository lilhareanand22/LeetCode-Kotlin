package top37program


fun countVowel(input: String): Map<Char, Int> {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val result = mutableMapOf<Char, Int>()

    for (char in input.lowercase()) {
        if (char in vowels) {
            result[char] = result.getOrDefault(char, 0) + 1
        }
    }

    return result
}

fun main() {
    val input = "Hello World"

    val result = countVowel(input)

   result.forEach { (char, count) ->
       println("$char -> $count")
   }
}