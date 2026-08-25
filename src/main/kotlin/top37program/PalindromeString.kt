package top37program

fun main() {
    val result = isPalindrome("madam")
    print(result)
}

fun isPalindrome(input: String): Boolean {
//    val reverse = input.reversed()
//    return input == reverse

    var reverse = ""
    for(index in input.length - 1 downTo 0) {
        reverse += input[index]
    }
    return input == reverse
}
