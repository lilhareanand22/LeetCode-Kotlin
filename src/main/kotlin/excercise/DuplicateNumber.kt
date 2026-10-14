package excercise


fun main() {
    val nums = intArrayOf(1,2,3,4,2)
    println("is contain is duplication in the array  :${containDuplicateSet(nums)}")
}


private fun containDuplicates(nums: IntArray) : Boolean {
    val map = mutableMapOf<Int, Int>()
    for(i in nums.indices) {
        var index= map[nums[i]]
        if(index != null){
            return true
        }
       map[nums[i]] = i
    }
    return false
}

private fun containDuplicateSet(nums:IntArray) : Boolean {
    val set = HashSet<Int>()
    for(num in nums) {
        if(set.contains(num)){
            println(num)
            return true
        } else {
            set.add(num)
        }
    }
    return false
}
