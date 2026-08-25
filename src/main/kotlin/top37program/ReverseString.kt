package top37program

fun main() {
   val result = reverseString("Android")
   println(result)
}

fun reverseString(str: String) : String {
    //return str.reversed()
   var reversedString = ""

    for(index in str.length -1 downTo 0) {
        reversedString += str[index]
    }

   return reversedString
}
