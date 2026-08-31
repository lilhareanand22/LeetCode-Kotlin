package top37program



fun main() {
    val result = permute("abc")
    println(result.joinToString())
}


fun permute(str: String): List<String> {
  if(str.length == 1) return listOf(str)

    val result = mutableListOf<String>()
    for(i in str.indices) {
        val char = str[i]
        val remaining = str.substring(0, i) + str.substring(i+1)
        for ( perm in permute(remaining)) {
            result.add(char + perm)
        }
    }

   return result
}