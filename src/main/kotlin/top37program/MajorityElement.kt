package top37program

fun majorityElement(nums: Array<Int>): Int {
    var candidate = 0
    var count = 0

    for (num in nums) {

        if (count == 0) {
            candidate = num
        }

        if (num == candidate) {
            count++
        } else {
            count--
        }
    }

    return candidate
}

fun main() {
    val result = majorityElement(arrayOf(3, 3, 3, 3, 5, 4, 3, 4, 4))
    println(result)
}