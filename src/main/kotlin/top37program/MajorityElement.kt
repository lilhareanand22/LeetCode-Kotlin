package top37program





fun majorityElement(nums: Array<Int>): Int {
    var count = 0
    var candidate = 0

    for (num in nums) {
        if (count == 0) candidate = num
        if(num == candidate) {
          count += 1
        } else {
           count -= 1
        }
    }

    return candidate
}

fun main() {
    val result = majorityElement(arrayOf(3, 3, 4, 2, 4, 4, 2, 4, 4))
    println(result)
}