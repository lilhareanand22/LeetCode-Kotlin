package arrays

fun main() {
    val target = 10
    val nums = intArrayOf(4,5,6)
   // val nums = intArrayOf(2,7,11,15)
    println("printing the arry " + twoSum(nums,target).contentToString())
}


//Genericcode
fun twoSum(numbs : IntArray, target:Int) : IntArray {
    for (i in numbs.indices) {
        for( j in i+1 until numbs.size) {
            if(numbs[i] + numbs[j] == target) {
                return intArrayOf(i,j)
            }
        }
    }

    return intArrayOf()
}

//TwoSum - Optimized
fun twoSumOptimized(numbs : IntArray, target:Int) : IntArray {
    val map = HashMap<Int, Int>()
    for (i in numbs.iterator()) {
        var complement = target - numbs[i]
        var index = map[complement]
        if(index != null) {
           return intArrayOf(index, i)
        }
     map[complement] = i
    }
    return intArrayOf()
}