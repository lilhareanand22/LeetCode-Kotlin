package top37program


fun main() {
    val result = areAnagrams("listen", "silent")
    println("string is anagrams : $result")
}

fun areAnagrams(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val characterCounts = mutableMapOf<Char, Int>()

    for (character in str1) {
        characterCounts[character] = characterCounts.getOrDefault(character, 0) + 1
    }

    for (character in str2) {
        val count = characterCounts[character] ?: return false

        if (count == 1) {
            characterCounts.remove(character)
        } else {
            characterCounts[character] = count - 1
        }
    }

    return characterCounts.isEmpty()
}
/*
   Dry run for areAnagrams("listen", "silent"):

   1. Both strings have length 6, so the function continues.

   2. Count characters in "listen":
      l=1, i=1, s=1, t=1, e=1, n=1

   3. Read characters from "silent":
      s -> remove s       map: l, i, t, e, n
      i -> remove i       map: l, t, e, n
      l -> remove l       map: t, e, n
      e -> remove e       map: t, n
      n -> remove n       map: t
      t -> remove t       map: empty

   4. The map is empty, so the strings are anagrams.
   Output: string is anagrams : true
*/