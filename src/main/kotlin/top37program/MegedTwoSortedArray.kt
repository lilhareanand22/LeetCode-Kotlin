package top37program




fun main() {
    val result = mergeSortedArrays(arrayOf(1, 3, 5), arrayOf(2, 4, 6))
    println(result.joinToString())
}

fun mergeSortedArrays(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    return (arr1 + arr2).sortedArray()
}

