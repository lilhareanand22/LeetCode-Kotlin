# Two Sum

## Problem Statement

Given an integer array `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

- Exactly one valid answer exists.
- The same element cannot be used twice.
- Return indices in any order.

---

## Example

### Example 1

Input

```text
nums = [2,7,11,15]
target = 9
```

Output

```text
[0,1]
```

Explanation

```text
nums[0] + nums[1] = 2 + 7 = 9
```

---

## Approach 1 : Brute Force

### Idea

Check every possible pair.

```
for every element
    compare with every remaining element
    if sum == target
        return indices
```

### Algorithm

```
for i from 0 to n-1
    for j from i+1 to n-1
        if nums[i] + nums[j] == target
            return [i, j]
```

### Dry Run

```
nums = [2,7,11,15]
target = 9
```

Iteration

```
i = 0

j = 1

2 + 7 = 9 ✅

Return [0,1]
```

### Time Complexity

```
O(n²)
```

Reason

```
Nested loops
```

### Space Complexity

```
O(1)
```

No extra memory used.

---

# Optimized Approach (HashMap)

## Key Idea

Instead of searching again,
store previously visited numbers inside a HashMap.

```
HashMap

Key   -> Number
Value -> Index
```

Example

```
{
2 -> 0
7 -> 1
11 -> 2
}
```

For every element

```
Need = target - currentNumber
```

If the needed number already exists inside HashMap

```
Return answer
```

Otherwise

```
Store current number
```

---

## Algorithm

```
Create empty HashMap

Loop through array

    complement = target - nums[i]

    if complement exists in HashMap
        return [map[complement], i]

    else
        store nums[i] with its index

Return empty array
```

---

## Dry Run

Input

```
nums = [2,7,11,15]

target = 9
```

Initial

```
Map = {}
```

### Iteration 1

```
Current = 2

Need = 7

Map = {}
```

Not found

Store

```
2 -> 0
```

Map

```
{
2 = 0
}
```

---

### Iteration 2

```
Current = 7

Need = 2
```

Map

```
{
2 = 0
}
```

Found

Return

```
[0,1]
```

---

## Another Dry Run

```
nums = [3,2,4]

target = 6
```

Initial

```
Map = {}
```

### Step 1

```
Current = 3

Need = 3

Store

3 -> 0
```

Map

```
{
3 = 0
}
```

---

### Step 2

```
Current = 2

Need = 4

Store

2 -> 1
```

Map

```
{
3 = 0
2 = 1
}
```

---

### Step 3

```
Current = 4

Need = 2

Found
```

Return

```
[1,2]
```

---

# Visualization

```
Target = 9

Current = 2

Need = 7

Map = {}

↓

Store

2 -> 0

↓

Current = 7

Need = 2

Map contains 2

↓

Answer Found
```

---

# Kotlin Code

```kotlin
fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = HashMap<Int, Int>()

    for (i in nums.indices) {

        val complement = target - nums[i]

        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }

        map[nums[i]] = i
    }

    return intArrayOf()
}
```

---

# Complexity Analysis

## Brute Force

Time Complexity

```
O(n²)
```

Space Complexity

```
O(1)
```

---

## Optimized (HashMap)

Time Complexity

```
O(n)
```

Reason

```
Single traversal of array

HashMap lookup = O(1) average

HashMap insertion = O(1) average
```

Space Complexity

```
O(n)
```

Reason

```
HashMap may store all elements.
```

---

# Interview Notes

### Why HashMap?

Because searching inside an array takes **O(n)**, while HashMap lookup is **O(1)** on average.

---

### Why check complement before inserting?

To avoid using the same element twice.

Example

```
nums = [3,3]

target = 6
```

If we insert first, we might accidentally use the same index.

Checking first ensures two different indices are returned.

---

### Formula

```
Complement = Target - CurrentNumber
```

---

# Key Takeaways

✅ Learn to convert nested loops into HashMap lookup.

✅ Think in terms of "What number do I need?"

```
Need = Target - CurrentNumber
```

✅ Store visited numbers.

✅ Lookup complement in O(1).

---

# Pattern Learned

```
Array + HashMap

↓

Store visited values

↓

Find complement

↓

Return indices
```

This is one of the most frequently asked array + HashMap interview patterns and forms the foundation for many other problems like Three Sum, Four Sum, Subarray Sum Equals K, and Two Sum II.