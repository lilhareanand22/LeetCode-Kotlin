package arrays.hashing

fun main() {
    val k = 2
    val nums = intArrayOf(1,1,1,2,2,3)
    println("get top $k value is ${topKFrequent(nums, k).contentToString()}")
}

fun topKFrequent(numbs: IntArray, k:Int) : IntArray {
    val frequencyMap = HashMap<Int, Int>()

    for (num in numbs) {
        frequencyMap[num] = frequencyMap.getOrDefault(num,0) + 1
    }
    val sortedMap = frequencyMap.entries.sortedByDescending { it.value }

    val result = IntArray(k)
    for(i in 0 until k) {
        result[i]  = sortedMap[i].key
    }
    return result
}