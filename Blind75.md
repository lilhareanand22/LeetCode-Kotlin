# Blind 75 Progress

## Binary Search

| Category | Program name | Complexity | Steps of algorithm |
|---|---|---|---|
| Binary Search | [Binary Search](src/main/kotlin/Blind75/binary/search/BinarySearch1.kt) | Time: `O(log n)` · Space: `O(1)` | 1. Set `left` to the first index and `right` to the last index. 2. Calculate the middle index. 3. Return the middle index when its value equals the target. 4. Search the left or right half based on the comparison. 5. Return `-1` when the target is not found. |
| Binary Search | [Search Insert Position](src/main/kotlin/Blind75/binary/search/BinarySearchIfNotFoundThenSuggestIndex1.kt) | Time: `O(log n)` · Space: `O(1)` | 1. Set `left` and `right` to the bounds of the sorted array. 2. Compare the target with the middle value. 3. Narrow the search to the appropriate half. 4. Return the target index if found. 5. Return `left`, the position where the target should be inserted. |
| Binary Search | [Find Minimum in Rotated Sorted Array](src/main/kotlin/Blind75/binary/search/FindMinumumInRotatedArray.kt) | Time: `O(log n)` · Space: `O(1)` | 1. Set `left` and `right` to the array bounds. 2. Compare the middle value with the rightmost value. 3. Move `left` right when the minimum is in the right half. 4. Otherwise move `right` to `mid`. 5. Return the value at the converged index. |
| Binary Search | [Search in Rotated Sorted Array](src/main/kotlin/Blind75/binary/search/RotatedBinarySearch.kt) | Time: `O(log n)` · Space: `O(1)` | 1. Calculate the middle index. 2. Return the index when the middle value equals the target. 3. Identify which half is sorted. 4. Keep the target-containing half and discard the other half. 5. Return `-1` when the target is not found. |

## Two Pointer

| Category | Program name | Complexity | Steps of algorithm |
|---|---|---|---|
| Two Pointer | [Valid Palindrome](src/main/kotlin/Blind75/TwoPointer/ValidPalindrom.kt) | Time: `O(n)` · Space: `O(1)` | 1. Set `left` at the start and `right` at the end of the string. 2. Skip non-alphanumeric characters from both sides. 3. Compare the lowercase characters at both pointers. 4. Return `false` when they differ. 5. Move both pointers inward and return `true` when they meet. |

| Category | Program name | Complexity | Steps of algorithm |
|---|---|---|---|
| Arrays & Hashing | [Contains Duplicate](src/main/kotlin/Blind75/array/hashing/ContainsDuplicat.kt) | Time: `O(n)` · Space: `O(n)` | 1. Create an empty `HashSet`. 2. Scan each number. 3. If the number is already in the set, return `true`. 4. Otherwise add it to the set. 5. Return `false` after scanning all numbers. |
| Arrays & Hashing | [Anagram](src/main/kotlin/Blind75/array/hashing/Anagram.kt) | Time: `O(n)` · Space: `O(k)` | 1. If the strings have different lengths, return `false`. 2. Count each character in the first string using a `HashMap`. 3. Scan the second string and decrease each character count. 4. Return `false` if a character is missing or overused. 5. Return `true` if all characters match. |
| Arrays & Hashing | [Two Sum](src/main/kotlin/Blind75/array/hashing/TwoSum.kt) | Time: `O(n)` · Space: `O(n)` | 1. Create an empty `HashMap` for numbers and their indexes. 2. For each number, calculate its complement: `target - number`. 3. If the complement is already in the map, return both indexes. 4. Otherwise store the current number and index. 5. Return an empty array if no pair exists. |
| Arrays & Hashing | [Group Anagram](src/main/kotlin/Blind75/array/hashing/GroupAnagram.kt) | Time: `O(n · k log k)` · Space: `O(n · k)` | 1. Create a `HashMap` from sorted-character keys to word lists. 2. Sort the characters of each word to create its key. 3. Add the word to the list for that key. 4. Return all grouped word lists. |
| Arrays & Hashing | [Top K Frequent](src/main/kotlin/Blind75/array/hashing/TopKFrequent.kt) | Time: `O(n + m log m)` · Space: `O(m)` | 1. Count each number using a `HashMap`. 2. Sort the map entries by frequency in descending order. 3. Select the first `k` keys. 4. Return the selected numbers. |
| Arrays & Hashing | [Encoding and Decoding](src/main/kotlin/Blind75/array/hashing/EncodingAndDecoding.kt) | Time: `O(n)` · Space: `O(n)` | 1. Prefix each string with its length and `#`. 2. Append all prefixed strings into one encoded string. 3. During decoding, find each `#` delimiter. 4. Read the length and extract exactly that many characters. 5. Continue until all strings are restored. |
| Arrays & Hashing | [Product Except Self](src/main/kotlin/Blind75/array/hashing/ProductExceptSelf.kt) | Time: `O(n)` · Space: `O(n)` | 1. Create prefix and suffix product arrays. 2. Store the product of all values before each index in `prefix`. 3. Store the product of all values after each index in `suffix`. 4. Multiply `prefix[i]` and `suffix[i]` for each result. 5. Return the result array. |
