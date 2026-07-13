# Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` represents the stock
price on the **i-th day**.

Rules: - Buy only **once**. - Sell only **once**. - Buy must happen
**before** sell. - Return the **maximum profit**. - If no profit is
possible, return **0**.

------------------------------------------------------------------------

## Example

### Example 1

**Input**

``` text
prices = [7,1,5,3,6,4]
```

**Output**

``` text
5
```

**Explanation**

Buy at price **1** and sell at price **6**.

Profit = `6 - 1 = 5`

------------------------------------------------------------------------

### Example 2

**Input**

``` text
prices = [7,6,4,3,1]
```

**Output**

``` text
0
```

No profitable transaction is possible.

------------------------------------------------------------------------

# Brute Force Approach

## Idea

Try every possible buying day with every future selling day.

### Algorithm

``` text
maxProfit = 0

for i = 0 to n-1
    for j = i+1 to n-1
        profit = prices[j] - prices[i]
        maxProfit = max(maxProfit, profit)

return maxProfit
```

### Time Complexity

``` text
O(n²)
```

### Space Complexity

``` text
O(1)
```

------------------------------------------------------------------------

# Optimized Approach (Greedy)

## Key Idea

Maintain two variables:

-   `minPrice` → Lowest price seen so far.
-   `maxProfit` → Maximum profit found so far.

For every price:

``` text
profit = currentPrice - minPrice
```

Update `maxProfit`.

If a smaller price is found, update `minPrice`.

------------------------------------------------------------------------

## Algorithm

``` text
minPrice = first element
maxProfit = 0

for each remaining price

    if currentPrice < minPrice
        minPrice = currentPrice

    else
        profit = currentPrice - minPrice
        maxProfit = max(maxProfit, profit)

return maxProfit
```

------------------------------------------------------------------------

# Dry Run

Input

``` text
prices = [7,1,5,3,6,4]
```

    Day   Price   Min Price   Today's Profit   Max Profit
  ----- ------- ----------- ---------------- ------------
      1       7           7                0            0
      2       1           1                0            0
      3       5           1                4            4
      4       3           1                2            4
      5       6           1                5            5
      6       4           1                3            5

Answer

``` text
5
```

------------------------------------------------------------------------

# Kotlin Solution

``` kotlin
fun maxProfit(prices: IntArray): Int {

    var minPrice = prices[0]
    var maxProfit = 0

    for (i in 1 until prices.size) {

        if (prices[i] < minPrice) {
            minPrice = prices[i]
        } else {
            val profit = prices[i] - minPrice
            maxProfit = maxOf(maxProfit, profit)
        }
    }

    return maxProfit
}

fun main() {

    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val result = maxProfit(prices)

    println("Maximum Profit: $result")
}
```

------------------------------------------------------------------------

## Output

``` text
Maximum Profit: 5
```

------------------------------------------------------------------------

# Complexity Analysis

  Approach      Time    Space
  ------------- ------- -------
  Brute Force   O(n²)   O(1)
  Greedy        O(n)    O(1)

------------------------------------------------------------------------

# Why Greedy?

At every step we make the best local decision:

-   Keep the lowest buying price.
-   Calculate profit if sold today.
-   Update the maximum profit.

This guarantees the optimal solution in a single traversal.

------------------------------------------------------------------------

# Interview Notes

### Why not HashMap?

HashMap is useful when fast lookups are needed.

Here, we only need the **minimum price so far**, so two variables are
enough.

------------------------------------------------------------------------

### Formula

``` text
Profit = Current Price - Minimum Price
```

------------------------------------------------------------------------

# Pattern Learned

``` text
Array

↓

Running Minimum

↓

Current Profit

↓

Maximum Profit

↓

Greedy (Single Pass)
```

------------------------------------------------------------------------

# Key Takeaways

-   Buy before selling.
-   Track the minimum price seen so far.
-   Calculate profit for each day.
-   Update maximum profit.
-   One pass solution.
-   Time Complexity: **O(n)**
-   Space Complexity: **O(1)**
