package excercise



fun main() {

    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val result = maxProfitOpt(prices)

    println("Maximum Profit: $result")
}

private fun maxProfitOpt(prices: IntArray) : Int {
    var maxProfit = 0
    var minprices = prices[0]
    for (i in 1 until prices.size) {
        if(prices[i] < minprices) {
            minprices = prices[i]
        } else {
          val profit = prices[i]- minprices
          maxProfit = maxOf(maxProfit, profit)
        }
    }
    return maxProfit
}