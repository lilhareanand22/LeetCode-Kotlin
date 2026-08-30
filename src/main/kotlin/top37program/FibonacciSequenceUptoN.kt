package top37program



fun main() {
    val result = generateFibonacci(10)
    println(result)
}

fun generateFibonacci(n : Int) : List<Int> {
    val fibonacci = mutableListOf(0,1)
    for(i in 2 until n) {
        fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2])
    }
    return fibonacci
}