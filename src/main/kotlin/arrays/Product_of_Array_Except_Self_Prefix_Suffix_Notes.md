# Product of Array Except Self (Prefix + Suffix Approach)

## Problem Statement

Given an integer array `nums`, return an array `answer` where:

`answer[i]` is the product of all elements except `nums[i]`.

-   Time Complexity: **O(n)**
-   Division is **not allowed**

------------------------------------------------------------------------

## Example

Input

``` text
nums = [1,2,3,4]
```

Output

``` text
[24,12,8,6]
```

------------------------------------------------------------------------

# Core Idea

For every index:

``` text
Answer = Left Product × Right Product
```

-   Left Product → Prefix Array
-   Right Product → Suffix Array

------------------------------------------------------------------------

# Prefix Array

For each index, store the product of all elements to its left.

Example

``` text
nums = [1,2,3,4]
```

     Index   0   1   2   3
  -------- --- --- --- ---
    Prefix   1   1   2   6

Formula

``` text
Prefix[0] = 1
Prefix[i] = Prefix[i-1] × nums[i-1]
```

------------------------------------------------------------------------

# Suffix Array

For each index, store the product of all elements to its right.

     Index    0    1   2   3
  -------- ---- ---- --- ---
    Suffix   24   12   4   1

Formula

``` text
Suffix[last] = 1
Suffix[i] = Suffix[i+1] × nums[i+1]
```

------------------------------------------------------------------------

# Dry Run

``` text
Nums    : 1   2   3   4
Prefix  : 1   1   2   6
Suffix  : 24 12   4   1
Answer  : 24 12   8   6
```

    Index   Prefix   Suffix   Answer
  ------- -------- -------- --------
        0        1       24       24
        1        1       12       12
        2        2        4        8
        3        6        1        6

------------------------------------------------------------------------

# Kotlin Code

``` kotlin
fun productExceptSelf(nums: IntArray): IntArray {

    val n = nums.size

    val prefix = IntArray(n)
    val suffix = IntArray(n)
    val answer = IntArray(n)

    prefix[0] = 1
    for (i in 1 until n) {
        prefix[i] = prefix[i - 1] * nums[i - 1]
    }

    suffix[n - 1] = 1
    for (i in n - 2 downTo 0) {
        suffix[i] = suffix[i + 1] * nums[i + 1]
    }

    for (i in nums.indices) {
        answer[i] = prefix[i] * suffix[i]
    }

    return answer
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    println(productExceptSelf(nums).joinToString(", "))
}
```

Output

``` text
24, 12, 8, 6
```

------------------------------------------------------------------------

# Complexity

  Approach          Time   Space
  ----------------- ------ -------
  Prefix + Suffix   O(n)   O(n)

------------------------------------------------------------------------

# Key Takeaways

-   Prefix stores the left product.
-   Suffix stores the right product.
-   Final Answer:

``` text
Answer[i] = Prefix[i] × Suffix[i]
```

-   This approach is the foundation for the O(1) extra space
    optimization.
