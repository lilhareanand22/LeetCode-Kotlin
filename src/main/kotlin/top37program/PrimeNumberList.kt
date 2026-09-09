package top37program

fun isPrime1(number: Int): Boolean {
    if (number < 2) return false

    for (i in 2 .. Math.sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            return false
        }
    }

    return true
}

fun main() {
    val numbers = arrayOf(2, 3, 4, 5, 7, 8, 10, 11, 13, 15, 17)

    for (number in numbers) {
        if (isPrime1(number)) {
            print("$number ")
        }
    }
}