package top37program

fun findDuplicates(arr: Array<Int>): List<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableListOf<Int>()

    for (num in arr) {
        if (num in seen) {
            duplicates.add(num)
        } else {
            seen.add(num)
        }
    }

    return duplicates
}

fun main() {
    val result = findDuplicates(arrayOf(1, 2, 3, 4, 2, 5, 3))
    println(result.joinToString())

}