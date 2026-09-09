package top37program

fun findPrimeNumbers(numbers: Array<Int>): Array<Int> {
 return numbers.filter{ number ->
     if(number < 2) {
          false
     }
     else {
        for(i in 2 .. Math.sqrt(number.toDouble()).toInt()) {
            if(number % i == 0){
                return@filter false
            }
        }
          true
     }

 }.toTypedArray()
}

fun main() {
    val numbers = arrayOf(2, 3, 4, 5, 7, 8, 10, 11, 13, 15, 17)

    val primeNumbers = findPrimeNumbers(numbers)

    println(primeNumbers.contentToString())
}