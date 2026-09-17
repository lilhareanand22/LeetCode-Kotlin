package Blind75.array.hashing

fun main() {
    val nums = intArrayOf(100, 4, 200, 1, 3, 2)
    val result = longestConsecutive(nums)

    println("Longest consecutive sequence length: $result")
}


fun longestConsecutive(nums: IntArray): Int {

    val set = nums.toHashSet()

    var longest = 0

    for (num in set) {

        // Check if num is the beginning of a sequence
        if (!set.contains(num - 1)) {

            var current = num
            var length = 1

            // Keep looking for the next number
            while (set.contains(current + 1)) {
                current++
                length++
            }

            longest = maxOf(longest, length)
        }
    }

    return longest
}
