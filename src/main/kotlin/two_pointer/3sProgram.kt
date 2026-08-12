package two_pointer

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    println(threeSum(nums))
}

/**
 * Finds every unique triplet whose sum is zero.
 *
 * Algorithm:
 * 1. Sort the array.
 * 2. Choose each value as the first number of a triplet (index i).
 * 3. Use two pointers for the remaining values: left = i + 1 and right = last index.
 * 4. If the three values sum to less than zero, move left rightward to increase the sum.
 *    If they sum to more than zero, move right leftward to decrease the sum.
 *    If they sum to zero, save the triplet and skip duplicate values.
 *
 * Dry run for [-1, 0, 1, 2, -1, -4]:
 * Sorted: [-4, -1, -1, 0, 1, 2]
 * i = 0 (-4): all possible sums are below zero, so no triplet is found.
 * i = 1 (-1):
 *   left = 2 (-1), right = 5 (2) -> sum = 0 -> add [-1, -1, 2]
 *   left = 3 (0),  right = 4 (1) -> sum = 0 -> add [-1, 0, 1]
 * i = 2 is skipped because it is a duplicate -1.
 * Result: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Time: O(n^2); extra space: O(1), excluding the returned result.
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    nums.sort()
    for (i in 0 until nums.size - 2) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            if (sum == 0) {
                result.add(
                    listOf(
                        nums[i],
                        nums[left],
                        nums[right]
                    )
                )
                // Skip duplicate left value
                while (left < right && nums[left] == nums[left + 1]) {
                    left++
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--
                }
                left++
                right--
            } else if (sum < 0) {
                left++
            } else {
                right--
            }
        }

    }
    return result
}


