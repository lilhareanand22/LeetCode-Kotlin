package top37program



fun main() {
    val result = isValidNumber("123.45")
    println(result)  // Output: true
}

fun isValidNumber(input: String): Boolean {
    return input.toDoubleOrNull() != null
}