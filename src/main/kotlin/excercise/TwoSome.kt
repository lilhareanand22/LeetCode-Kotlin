package excercise

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 26

    println(twoSumOptimized(nums, target).contentToString())
}

internal fun twoSumOptimized(numbs : IntArray, target:Int) : IntArray {
   val map  = HashMap<Int, Int>()
    for(num in numbs.indices){
        val compliment = target - numbs[num]
        var index = map[compliment]
        if(index != null) {
            return intArrayOf(index, num)
        }
        map[numbs[num]] = num
    }
    return intArrayOf()
}