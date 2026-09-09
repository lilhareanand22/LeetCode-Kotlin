package arrays.hashing

fun main() {
    val arr = intArrayOf(40,10,20,30)
    print("Rank of array is: ${arrayRankTransform(arr).contentToString()}")

}

fun arrayRankTransformBrute(arr: IntArray) : IntArray {
    val result = IntArray(arr.size)
    for (i in arr.indices) {
        var rank = 1
        val count = HashSet<Int>()
        for (j in arr.indices) {
            if(arr[j] < arr[i] && count.add(arr[j])) {
                rank++
            }
        }
        result[i] = rank
    }
    return result
}

private fun arrayRankTransform(arr: IntArray) : IntArray {
    if(arr.isEmpty()) return arr
    val sorted = arr.clone()
    sorted.sort()
    val rankMap = HashMap<Int, Int>()
    var rank = 1
    for(num in sorted) {
        if(!rankMap.containsKey(num)){
            rankMap[num] = rank++
        }
    }
    val answer = IntArray(arr.size)
    for(i in arr.indices) {
        answer[i] = rankMap[arr[i]]!!
    }
    return answer
}