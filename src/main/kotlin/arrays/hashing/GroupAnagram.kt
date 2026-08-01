package arrays.hashing

fun main() {
    val arr = arrayOf("eat","tea","tan","ate","nat","bat")
    println("Group Anagram: ${groupAnagram(arr)}")
}


fun groupAnagram(arr: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>> ()
    for (word in arr) {
        val key = word.toCharArray()
            .sorted()
            .joinToString("")

//        if(!map.containsKey(key)) {
//            map[key] = mutableListOf()
//        }
//        map[key]!!.add(word)
        map.getOrPut(key) { mutableListOf()} .add(word)
    }

    return map.values.toList()
}
