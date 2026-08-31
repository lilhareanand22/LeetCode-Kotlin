package top37program



fun main() {
    val arr = intArrayOf(12, 35, 1, 10, 34, 1)
    val result = thirdLargestElement(arr)
    if (result != null) {
        println("The third largest element is: $result")
    } else {
        println("Array has fewer than 3 distinct elements.")
    }
}


fun thirdLargestElement(arr: IntArray): Int? {
    if (arr.size < 3) return null  // Return null if there are fewer than 3 elements

    var first = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    var third = Int.MIN_VALUE

    for (num in arr) {
        if (num > first) {
            third = second
            second = first
            first = num
        } else if (num > second && num != first) {
            third = second
            second = num
        } else if (num > third && num != second) {
            third = num
        }
    }

    return if (third != Int.MIN_VALUE) third else null
}