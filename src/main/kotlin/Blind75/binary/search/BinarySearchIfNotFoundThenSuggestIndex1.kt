package Blind75.binary.search

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 2

    println(searchInsert1(nums, target))
}

fun searchInsert1(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size-1
    while (left <= right) {
        var mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid

            target < nums[mid] ->
                right = mid -1

            else -> left = mid+1
        }
    }
    return  left
}
