package top37program



fun main() {
    val result = firstNonRepeatedCharacter("swiss")
    println(result)
}

fun firstNonRepeatedCharacter(text: String): Char? {
//    val charCount = mutableMapOf<Char, Int>()
//    text.forEach { char -> charCount[char] = charCount.getOrDefault(char, 0) + 1 }
//    return text.find { char -> charCount[char] == 1 }


    val charFrq= HashMap<Char, Int>()

    for(char in text) {
        charFrq[char] = charFrq.getOrDefault(char, 0) + 1
    }
    for(char in text) {
        if(charFrq[char] == 1) {
            return char
        }
    }

    return null
}
