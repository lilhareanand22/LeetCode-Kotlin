package arrays


fun main() {
    val nums = intArrayOf(1,2,3,4)
    println("is contain is duplication in the array  :${containDuplicates(nums)}")
}


fun containDuplicates(nums: IntArray) : Boolean {
    val map = HashMap<Int, Int> ()
    for (i in nums.indices) {
        var index = map[nums[i]]
        if(index != null ) {
            return true
        }
        map[nums[i]] = i
    }

    return false
}


fun containsDuplicate(nums: IntArray): Boolean {

    for (i in nums.indices) {

        for (j in i + 1 until nums.size) {

            if (nums[i] == nums[j]) {
                return true
            }

        }
    }

    return false
}


fun containsDuplicateWithHashSet(nums: IntArray): Boolean {

    val set = HashSet<Int>()

    for (num in nums) {

        if (set.contains(num)) {
            return true
        }

        set.add(num)
    }

    return false
}