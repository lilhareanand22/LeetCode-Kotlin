package top37program



fun main() {
    val result = findMissingCharacter("thequickbrownfoxjumpsoverlazydog")
    println(result)
}

fun findMissingCharacter(input: String) : Char? {
    val fullAlphabet = "abcdefghijklmnopqrstuvwxyz"
    for (char in fullAlphabet) {
        if (char !in input) return char
    }
    return null
}