# Contains Duplicate

## Problem Statement

Given an integer array `nums`, return:

-   **true** if any value appears at least twice.
-   **false** if every element is distinct.

------------------------------------------------------------------------

## Examples

### Example 1

**Input**

``` text
nums = [1,2,3,1]
```

**Output**

``` text
true
```

Explanation: `1` appears more than once.

### Example 2

**Input**

``` text
nums = [1,2,3,4]
```

**Output**

``` text
false
```

### Example 3

**Input**

``` text
nums = [1,1,1,3,3,4,3,2,4,2]
```

**Output**

``` text
true
```

------------------------------------------------------------------------

# Pattern

``` text
Array + HashSet
```

------------------------------------------------------------------------

# Brute Force

Compare every pair.

## Algorithm

``` text
for i = 0 to n-1
    for j = i+1 to n-1
        if nums[i] == nums[j]
            return true
return false
```

### Time Complexity

`O(n²)`

### Space Complexity

`O(1)`

------------------------------------------------------------------------

# Optimized Approach (HashSet)

## Idea

Store visited values in a HashSet.

-   If current value already exists → return true.
-   Otherwise insert it.

## Algorithm

``` text
Create empty HashSet

For each number
    if number exists
        return true
    add number

return false
```

------------------------------------------------------------------------

# Dry Run

Input

``` text
nums = [1,2,3,1]
```

    Current Set Before   Exists   Set After
  --------- ------------ -------- -------------
          1 {}           No       {1}
          2 {1}          No       {1,2}
          3 {1,2}        No       {1,2,3}
          1 {1,2,3}      Yes      Return true

------------------------------------------------------------------------

# Kotlin Solution

``` kotlin
fun containsDuplicate(nums: IntArray): Boolean {

    val set = HashSet<Int>()

    for (num in nums) {

        if (set.contains(num)) {
            return true
        }

        set.add(num)
    }

    return false
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 1)

    println("Contains Duplicate: ${containsDuplicate(nums)}")
}
```

------------------------------------------------------------------------

# Complexity Analysis

  Approach      Time    Space
  ------------- ------- -------
  Brute Force   O(n²)   O(1)
  HashSet       O(n)    O(n)

------------------------------------------------------------------------

# HashSet vs HashMap

  -----------------------------------------------------------------------
  HashSet                             HashMap
  ----------------------------------- -----------------------------------
  Stores only values                  Stores Key → Value

  Used to detect duplicates           Used when additional information
                                      (index, count, etc.) is needed
  -----------------------------------------------------------------------

------------------------------------------------------------------------

# Interview Notes

-   Use **HashSet** when you only need to know whether a value has
    already been seen.
-   `contains()` and `add()` are **O(1)** on average.
-   Alternative approach: Sort the array and compare adjacent elements
    (`O(n log n)`).

------------------------------------------------------------------------

# Key Takeaways

-   Store visited values.
-   Check before adding.
-   Return immediately when a duplicate is found.
-   Average Time: **O(n)**
-   Space: **O(n)**

------------------------------------------------------------------------

# Pattern Learned

``` text
Array
 ↓
HashSet
 ↓
Seen Before?
 ↓
Yes → Return true
 ↓
No → Add to Set
```
