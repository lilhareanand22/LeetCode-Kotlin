package top37program

fun convertToEvenStringFlow(
    numbers: Sequence<Int>
): Sequence<String> {
    return numbers
        .filter { number -> number % 2 == 0 }
        .map { number -> number.toString() }
}

fun main() {
    val numbers = sequenceOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = convertToEvenStringFlow(numbers)

    println(evenNumbers.toList())
}
