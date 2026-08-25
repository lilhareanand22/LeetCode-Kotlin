package top37program



fun main() {
    val result = findMax(arrayOf(1, 3, 5, 7, 2))
    println(result)
}

fun findMax(numbers: Array<Int>): Int? {
    if (numbers.isEmpty()) {
        return null
    }
    //return numbers.maxOrNull()
    var max = numbers[0]

    for(index in 1 until numbers.size) {
        if(numbers[index] > max) {
            max = numbers[index]
        }
    }

  return max
}
