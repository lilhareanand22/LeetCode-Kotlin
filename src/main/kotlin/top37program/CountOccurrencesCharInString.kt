package top37program



fun main() {
    val result = countCharacterOccurrences("hello")
    println(result)
}

fun countCharacterOccurrences(input: String): Map<Char, Int> {
    val occurrences = mutableMapOf<Char, Int>()

    for (character in input) {
        occurrences[character] = (occurrences[character] ?: 0) + 1
    }

    return occurrences
    //return input.groupingBy { it }.eachCount()
}
