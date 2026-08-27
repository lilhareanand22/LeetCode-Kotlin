package top37program


fun main() {
    val result = largestPalindrome("babad")
    println(result)
}

fun largestPalindrome(input:String) : String{
    var largestPalindrome = ""
    for(i in input.indices) {
        for( j in i + 1..input.length) {
            val substring = input.substring(i, j)
            if(substring == substring.reversed() && substring.length > largestPalindrome.length) {
                largestPalindrome = substring
            }
        }
    }
    return largestPalindrome
}
