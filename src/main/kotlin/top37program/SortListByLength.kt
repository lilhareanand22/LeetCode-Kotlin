package top37program


fun main() {
    val result = sortByLength(listOf("apple", "banana", "cherry", "kiwi"))
    println(result.joinToString())
}
fun sortByLength(strings: List<String>): List<String> {
    return strings.sortedBy{it.length}
}