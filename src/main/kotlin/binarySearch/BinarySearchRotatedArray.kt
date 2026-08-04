package binarySearch

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0

    println(searchRotatedArray(nums, target))
}


fun searchRotatedArray(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1

    while (left <= right) {

        val mid = left + (right - left) / 2

        if (nums[mid] == target)
            return mid

        // Left half is sorted
        if (nums[left] <= nums[mid]) {

            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }

        } else {

            // Right half is sorted
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return -1
}
