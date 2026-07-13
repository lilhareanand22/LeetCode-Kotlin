package arrays

import kotlin.math.min

fun main() {

    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val result = maxProfitOpt(prices)

    println("Maximum Profit: $result")
}

fun maxProfit(prices : IntArray) : Int {
    var maxProfit = 0
    for (i in prices.indices) {
        for (j in i+1 until prices.size) {
            val profit = prices[j] - prices[i]
            maxProfit = maxOf(maxProfit, profit)
        }
    }
    return maxProfit
}

fun maxProfitOpt(prices: IntArray) : Int {
    var maxProfit =  0
    var minPrices = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] < minPrices) {
            minPrices = prices[i]
        } else {
            val profit = prices[i] - minPrices
            maxProfit = maxOf(maxProfit, profit)
        }
    }
    return maxProfit
}
