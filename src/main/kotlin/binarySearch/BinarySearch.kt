package binarySearch









fun main() {
    val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
    val target = 9

    println(search(nums, target))
}

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid

            target < nums[mid] ->
                right = mid -1

            else -> left = mid+1

        }


    }



    return -1
}
