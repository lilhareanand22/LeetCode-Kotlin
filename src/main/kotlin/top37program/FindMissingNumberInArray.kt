package top37program




fun main() {
    val result = findMissingNumber(arrayOf(1, 2, 4, 5), 5)
    println(result)
}

fun findMissingNumber(arr: Array<Int>, n: Int): Int {
    val totalSum = (n * (n + 1)) / 2
    val arrSum = arr.sum()
    return totalSum - arrSum
}

/*
Dry run for findMissingNumber(arrayOf(1, 2, 4, 5), 5):

The numbers from 1 to n should be:
1, 2, 3, 4, 5

Step 1: totalSum = (5 * (5 + 1)) / 2
                 = 30 / 2
                 = 15

Step 2: arrSum = 1 + 2 + 4 + 5
               = 12

Step 3: missing number = totalSum - arrSum
                       = 15 - 12
                       = 3

Output: 3
*/
