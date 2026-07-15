package arrays


fun main() {
    val numbs = intArrayOf(1,2,3,4)
    //var results = productExceptSelfDivision(numbs)
    var results = productExceptSelfPreFixAndSuffix(numbs)
    for (num in results) {
        print("$num ")
    }
}

fun productExceptSelfDivision(nums: IntArray): IntArray {
    var totalProduct = 1
    for(num in nums) {
        totalProduct *= num
    }
    var result = IntArray(nums.size)

    for (i in nums.indices) {
        result[i] = totalProduct / nums[i]
    }
    return result

}

fun productExceptBrutForce(nums: IntArray): IntArray {
    var result = IntArray(nums.size)
    for (i in nums.indices) {
        var product = 1
        for ( j in nums.indices) {
            if( i != j) {
               product *= nums[j]
            }
            result[i] = product
        }
    }
    return result
}

fun productExceptSelfPreFixAndSuffix(nums: IntArray): IntArray {
    val size = nums.size
    var result = IntArray(size)
    var prefix = IntArray(size)
    var suffix = IntArray(size)
    prefix[0] = 1
    suffix[size-1] = 1
    for( i in 1 until size) {
        prefix[i] = prefix[i-1] * nums[i -1]
    }
    for (i in size -2 downTo 0) {
        suffix[i] = suffix[i+1] * nums[i + 1]
    }
    for (i in nums.indices) {
        result[i] = prefix[i] * suffix[i]
    }
    return result
}