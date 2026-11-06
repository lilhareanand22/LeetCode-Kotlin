package two_pointer



fun moveZeroes(nums: IntArray) {

    var nonZeroIndex = 0

    for (i in nums.indices) {

        if (nums[i] != 0) {

            val temp = nums[i]
            nums[i] = nums[nonZeroIndex]
            nums[nonZeroIndex] = temp

            nonZeroIndex++
        }
    }
}

fun main() {

    val nums = intArrayOf(0, 1, 0, 3, 12)

    moveZeroes(nums)

    println(nums.contentToString())
}