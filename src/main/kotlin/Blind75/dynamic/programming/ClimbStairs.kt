package Blind75.dynamic.programming

fun climbStairs(n: Int): Int {
    if (n <= 2) return 0
    var dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]

    }
    return dp[n]
}






fun main() {
    val n = 5
    val result = climbStairs(n)

    println("Number of ways: $result")
}