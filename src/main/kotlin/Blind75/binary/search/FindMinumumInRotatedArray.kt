package Blind75.binary.search

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while(left < right) {
        val mid = left + (right - left)/2
        if(nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[left]
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println("Minimum element: ${findMin(nums)}")
}
