package top37program





fun main() {
    val result = findMissingNumber(intArrayOf(1, 2, 4, 5, 6))
    println(result)
}

fun findMissingNumber(arr: IntArray): Int {
    val n = arr.size + 1
    val totalSum = n * (n + 1) / 2
    val arrSum = arr.sum()
    return totalSum - arrSum
}