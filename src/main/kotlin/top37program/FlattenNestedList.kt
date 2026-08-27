package top37program




fun main() {
    val result = flatten(listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6)))
    println(result)
}

fun flatten(list: List<List<Int>>): List<Int> {
    return list.flatten()
}