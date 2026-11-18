package Blind75.dynamic.programming



fun lengthOfLIS(nums:IntArray) : Int {
    val size = nums.size

    val dp = IntArray(size) {
        1
    }
    var maxLength = 1
    for(i in 1 until size) {
        for(j in 0 until i) {
            if(nums[i] > nums[j]) {
                dp[i] = maxOf(dp[i],
                    dp[j] + 1)
            }
        }
        maxLength = maxOf(maxLength, dp[i])
    }
   return maxLength
}

fun main() {

    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)

    println(lengthOfLIS(nums)) // Output: 4
}