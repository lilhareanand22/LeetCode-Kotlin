package two_pointer




/**
 * Algorithm - Two Pointers
 *
 * 1. Set left to the first index and right to the last index.
 * 2. Initialize maxArea to 0.
 * 3. While left < right:
 *    - Calculate width = right - left.
 *    - Find the limiting height: min(height[left], height[right]).
 *    - Calculate area: width * limitingHeight.
 *    - Update maxArea if the current area is larger.
 *    - Move the pointer with the smaller height inward:
 *      - If height[left] < height[right], increment left.
 *      - Otherwise, decrement right.
 * 4. Return maxArea.
 *
 * The shorter line limits the container's water level. Moving the taller line
 * decreases the width and cannot improve that limiting height.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun maxArea(height: IntArray) : Int {

    var maxArea = 0
    var left = 0
    var right = height.size - 1

    while(left < right) {

        val width = right - left
        val currentHeight = minOf(height[right], height[left])
        val area = width * currentHeight
        maxArea = maxOf(maxArea, area)

        // Move the smaller height
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }


    }
    return maxArea
}

fun main() {
    val heights = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println("Maximum water container area: ${maxArea(heights)}")
}
