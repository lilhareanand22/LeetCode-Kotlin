package top37program


fun main() {
    val result = findSingleElement(arrayOf(4, 1, 2, 1, 2))
    println(result)
}


fun findSingleElement(arr: Array<Int>): Int {
    val frequencies = mutableMapOf<Int, Int>()

    for (num in arr) {
        frequencies[num] = frequencies.getOrDefault(num, 0) + 1
    }

    for (num in arr) {
        if (frequencies[num] == 1) {
            return num
        }
    }
    //return arr.reduce { acc, num -> acc xor num }
    throw IllegalArgumentException("Array does not contain a single element")
}
