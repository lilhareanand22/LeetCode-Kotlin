package top37program





fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    val arr2 = intArrayOf(2, 4, 5)

    val result = isSubset(arr1, arr2)
    if (result) {
        println("arr2 is a subset of arr1.")
    } else {
        println("arr2 is NOT a subset of arr1.")
    }
}


fun isSubset(arr1: IntArray, arr2: IntArray): Boolean {
    // Convert arr1 to a set for faster lookup
    val set1 = arr1.toHashSet()

    // Check if each element of arr2 is in arr1
    for (element in arr2) {
        if (!set1.contains(element)) {
            return false  // arr2 contains an element not in arr1
        }
    }
    return true  // All elements of arr2 are in arr1
}