# Kotlin LeetCode Algorithm Cheat Sheet

Concise notes for the algorithms in this repository. Start by recognizing the **DSA pattern** in a question; then use the matching algorithm.

## DSA Pattern Guide

| Pattern | Recognize it from the question | Problems in this repository |
|---|---|---|
| HashMap / HashSet | Find a matching value, count occurrences, detect repeats, or group related values | Two Sum, Contains Duplicate, Anagram, Group Anagrams, Top K Frequent |
| Prefix / Suffix | Compute each position using values before and after it | Product Except Self |
| One-pass tracking | Keep the best, smallest, or largest value seen so far | Best Time to Buy and Sell Stock |
| Sorting + mapping | Sort values first, then assign or compare positions | Rank Transform, Merge Intervals |
| Binary search | Input is sorted, or one sorted half can be identified | Binary Search, Search Insert Position, Rotated Array Search |
| Two pointers | Compare, scan, or rearrange from both ends of an array or string | Valid Palindrome, Container With Most Water, Three Sum |
| Stack | Need most-recent unfinished work first; nested brackets or matching pairs | Valid Parentheses, Decode String, Count of Atoms, Molecular Weight |
| String prefix | All strings must share the same beginning characters | Longest Common Prefix |

## How to choose a pattern

1. **"Have I seen this before?"** → Use a `HashSet` or `HashMap`.
2. **"Find two values that make a target."** → Store complements in a `HashMap`.
3. **"The array is sorted."** → Consider binary search.
4. **"Compare values from the beginning and end."** → Use two pointers.
5. **"Nested brackets / latest opening item must close first."** → Use a stack.
6. **"Every answer needs left and right products."** → Use prefix and suffix arrays.
7. **"Intervals overlap."** → Sort by start, then merge.
8. **"Need best profit / minimum seen so far."** → Scan once while tracking the best value.

## Array and Hashing

### Two Sum — HashMap complement

**Pattern:** HashMap complement / lookup.

1. For each value, calculate `needed = target - current`.
2. If `needed` is already stored, return its index and the current index.
3. Otherwise store `current -> index`.

```text
map = empty map
for each index i:
    needed = target - nums[i]
    if needed is in map: return [map[needed], i]
    map[nums[i]] = i
```

Time: `O(n)` · Space: `O(n)`

### Contains Duplicate — HashSet

**Pattern:** HashSet — "seen before?"

```text
seen = empty set
for each number:
    if number is in seen: return true
    add number to seen
return false
```

Time: `O(n)` · Space: `O(n)`

### Valid Anagram — frequency map

**Pattern:** HashMap frequency counting.

```text
if lengths differ: return false
count every character in first string
for each character in second string:
    if character is absent or its count becomes negative: return false
return true
```

Time: `O(n)` · Space: `O(n)`

### Group Anagrams — sorted-word key

**Pattern:** HashMap grouping with a canonical sorted key.

```text
groups = empty map  // sorted word -> list of original words
for each word:
    key = characters of word sorted and joined
    add word to groups[key]
return all group lists
```

Time: `O(n * k log k)` · Space: `O(n * k)`

### Top K Frequent Elements — count then sort

**Pattern:** Frequency map + sorting.

```text
frequency = count every number
sort frequency entries by count descending
return keys of first k entries
```

Time: `O(n + m log m)` · Space: `O(m)`

### Rank Transform — sort and map

**Pattern:** Sorting + HashMap lookup.

```text
sorted = copy of input, sorted
rank = 1
for each number in sorted:
    if number has no rank: assign rank and increment rank
for each number in original input:
    answer[index] = rank map[number]
```

Time: `O(n log n)` · Space: `O(n)`

### Product Except Self — prefix and suffix

**Pattern:** Prefix and suffix products.

```text
prefix[0] = 1
for i from 1 to end: prefix[i] = prefix[i - 1] * nums[i - 1]
suffix[last] = 1
for i from second-last down to 0: suffix[i] = suffix[i + 1] * nums[i + 1]
for each i: answer[i] = prefix[i] * suffix[i]
```

Time: `O(n)` · Space: `O(n)`

### Best Time to Buy and Sell Stock — one pass

**Pattern:** One-pass minimum tracking.

```text
minPrice = first price
maxProfit = 0
for each later price:
    if price < minPrice: minPrice = price
    else: maxProfit = max(maxProfit, price - minPrice)
return maxProfit
```

Time: `O(n)` · Space: `O(1)`

### Longest Common Prefix — shrink prefix

**Pattern:** Incremental string-prefix comparison.

```text
prefix = first word
for each remaining word:
    while word does not start with prefix:
        remove last character from prefix
        if prefix is empty: return ""
return prefix
```

Time: `O(n * m)` · Space: `O(1)`

## Binary Search

### Standard Binary Search

**Pattern:** Binary search on a sorted array.

```text
left = 0; right = last index
while left <= right:
    mid = left + (right - left) / 2
    if nums[mid] == target: return mid
    if target < nums[mid]: right = mid - 1
    else: left = mid + 1
return -1
```

Time: `O(log n)` · Space: `O(1)`

### Search Insert Position

**Pattern:** Binary search for a lower-bound insertion index.

Use standard binary search. If the target is not found, return `left`: it is the first valid insertion position.

```text
while left <= right:
    calculate mid
    if found: return mid
    if nums[mid] < target: left = mid + 1
    else: right = mid - 1
return left
```

### Search in Rotated Sorted Array

**Pattern:** Modified binary search; one half remains sorted.

At every step, at least one half is sorted.

```text
while left <= right:
    mid = middle index
    if nums[mid] == target: return mid
    if left half is sorted:
        search it only when target belongs to its range
    else:
        search the sorted right half only when target belongs to its range
return -1
```

Time: `O(log n)` · Space: `O(1)`

## Two Pointers

### Valid Palindrome

**Pattern:** Two pointers moving inward from both ends.

**Goal:** Check whether a string reads the same forward and backward after ignoring case and non-alphanumeric characters.

```text
left = first index; right = last index
while left < right:
    while left < right and left character is not a letter/digit:
        move left rightward
    while left < right and right character is not a letter/digit:
        move right leftward
    if lowercase(left character) != lowercase(right character):
        return false
    move left rightward
    move right leftward
return true
```

Example: `"A man, a plan, a canal: Panama"` returns `true`.

Time: `O(n)` · Space: `O(1)`

### Container With Most Water

**Pattern:** Two pointers moving inward from both ends.

**Goal:** Find two vertical lines that hold the greatest amount of water. The area is the smaller height multiplied by the distance between the lines.

```text
left = first index; right = last index
maxArea = 0
while left < right:
    width = right - left
    currentArea = width * min(height[left], height[right])
    maxArea = max(maxArea, currentArea)
    if height[left] < height[right]:
        move left rightward
    else:
        move right leftward
return maxArea
```

Move the shorter line because it limits the water height. Moving the taller line reduces the width and cannot improve the limiting height.

Example: `[1, 8, 6, 2, 5, 4, 8, 3, 7]` returns `49`.

Time: `O(n)` · Space: `O(1)`

### Three Sum

**Pattern:** Sort + two pointers.

**Goal:** Find every unique triplet whose values add up to `0`.

```text
sort nums
for each index i up to the third-last index:
    skip i when it is the same as the previous value
    left = i + 1; right = last index
    while left < right:
        sum = nums[i] + nums[left] + nums[right]
        if sum < 0: move left rightward
        else if sum > 0: move right leftward
        else:
            save [nums[i], nums[left], nums[right]]
            skip duplicate left and right values
            move both pointers inward
return result
```

Dry run for `[-1, 0, 1, 2, -1, -4]`:

```text
Sorted: [-4, -1, -1, 0, 1, 2]
i = 0 (-4): no zero-sum triplet is possible.
i = 1 (-1), left = 2 (-1), right = 5 (2): sum = 0 -> [-1, -1, 2]
i = 1 (-1), left = 3 (0), right = 4 (1):  sum = 0 -> [-1, 0, 1]
i = 2 is skipped because -1 is a duplicate.
Result: [[-1, -1, 2], [-1, 0, 1]]
```

Time: `O(n²)` · Space: `O(1)` excluding the returned result.

## Stack and Strings

### Valid Parentheses — matching stack

**Pattern:** Stack for matching nested pairs.

```text
stack = empty
for each character:
    if opening bracket: push it
    if closing bracket:
        if stack is empty: return false
        pop top; if it does not match: return false
return stack is empty
```

Time: `O(n)` · Space: `O(n)`

### Decode String — two stacks

**Pattern:** Stack for nested repeat groups.

Pattern: `3[a2[c]] -> accaccacc`.

```text
numberStack = empty; stringStack = empty
for each character:
    if digit: build currentNumber
    if '[': push currentNumber and currentString; reset both
    if letter: append to currentString
    if ']':
        times = pop numberStack; previous = pop stringStack
        currentString = previous + currentString repeated times
return currentString
```

Time: `O(n + decoded output length)` · Space: `O(n)`

### Count of Atoms — stack of maps

**Pattern:** Stack of HashMaps for nested-group frequency counts.

```text
stack = empty stack of maps
currentMap = empty map
while formula remains:
    if '(':
        push currentMap; currentMap = empty map
    else if ')':
        read multiplier, defaulting to 1
        multiply currentMap counts
        pop previous map and merge currentMap into it
    else:
        read atom name and count, defaulting to 1
        add count to currentMap[atom]
sort atom names and append name + count when count > 1
```

Time: `O(n + k log k)` · Space: `O(n)`

### Molecular Weight Without Brackets

**Pattern:** Linear parsing / scanning.

```text
totalWeight = 0
while formula remains:
    read atom name and count, defaulting to 1
    totalWeight += atomicWeight[atom] * count
return totalWeight
```

### Molecular Weight With Brackets

**Pattern:** Stack of HashMaps for nested molecular groups.

Use the same stack-of-maps pattern as Count of Atoms. After parsing, calculate `atomicWeight[atom] * atomCount` for every atom and add it to the total.

## Intervals

### Merge Intervals

**Pattern:** Sort first, then merge overlapping ranges.

```text
if input is empty: return empty
sort intervals by start
result = first interval
for each remaining interval:
    last = last interval in result
    if current.start <= last.end:
        last.end = max(last.end, current.end)
    else:
        add current to result
return result
```

Time: `O(n log n)` · Space: `O(n)`
