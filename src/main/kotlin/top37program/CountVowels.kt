package top37program

fun main() {
    val result = countVowels("Hello World")
    println(result)
}

fun countVowels(string: String): Int {

   // return string.count {it in "aieouAIEOU"}
    var vowelCount = 0

   for (char in string) {
       when(char) {
           'a', 'e', 'i','o','u',
           'A', 'E', 'I', 'O', 'U' -> vowelCount++
       }
   }

    return vowelCount
}
