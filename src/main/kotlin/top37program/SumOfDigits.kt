package top37program

fun main() {
    val result = sumOfDigits(12345)
    println(result)
}

fun sumOfDigits(num : Int) : Int {
    //return num.toString().map{it.toString().toInt()}.sum()
    var number = num
    var sum = 0

    while (number != 0) {
        sum += number % 10
        number /= 10
    }

    return sum
}

/*
Dry run for sumOfDigits(12345):

Initial values:
number = 12345
sum = 0

Step 1: digit = 12345 % 10 = 5
        sum = 0 + 5 = 5
        number = 12345 / 10 = 1234

Step 2: digit = 1234 % 10 = 4
        sum = 5 + 4 = 9
        number = 1234 / 10 = 123

Step 3: digit = 123 % 10 = 3
        sum = 9 + 3 = 12
        number = 123 / 10 = 12

Step 4: digit = 12 % 10 = 2
        sum = 12 + 2 = 14
        number = 12 / 10 = 1

Step 5: digit = 1 % 10 = 1
        sum = 14 + 1 = 15
        number = 1 / 10 = 0

The loop ends because number == 0.
Final result: 15
Output: 15
*/

