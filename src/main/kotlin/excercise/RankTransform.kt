package excercise



fun main() {
    val arr = intArrayOf(40,10,20,30)
    print("Rank of array is: ${arrayRankTransform(arr).contentToString()}")

}

fun arrayRankTransform(arr: IntArray) : IntArray {
    if(arr.isEmpty()) return arr
    var sorted = arr.clone()
    sorted.sort()
    val rankArray = HashMap<Int, Int>()
    var rank = 1
    for(num in sorted) {
        if(!rankArray.containsKey(num)){
            rankArray[num] = rank++
        }
    }
    val result = IntArray(arr.size)
    for(i in arr.indices) {
        result[i] = rankArray[arr[i]]!!
    }
    return result
}