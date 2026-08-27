package top37program


fun main() {
    val result = intersectArrays(arrayOf(1, 2, 3, 4), arrayOf(3, 4, 5, 6))
    println(result.joinToString())

    // Second way
    val result1 = intersectArrays(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(3, 4, 5, 6)
    )

    println(result1.joinToString())
}

fun intersectArrays(aar1:Array<Int>, aar2:Array<Int>) : Array<Int> {
    return aar1.filter { it in aar2}.toTypedArray()
}


fun intersectArrays(arr1: IntArray, arr2: IntArray): IntArray {
    val result = IntArray(arr1.size)
    var count = 0

    for (number1 in arr1) {
        for (number2 in arr2) {
            if (number1 == number2) {
                result[count] = number1
                count++
                break
            }
        }
    }

    return result.copyOf(count)
}