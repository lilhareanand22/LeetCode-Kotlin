package binarySearch

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 2

    println(searchInsert(nums, target))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size-1
    while (left <= right) {
        var mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid

            nums[mid] < target ->
                left = mid + 1
            else ->
                right = mid -1
        }
    }
    return  left
}
