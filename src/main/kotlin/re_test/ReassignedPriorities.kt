package re_test

fun main() {
    val priorities = intArrayOf(40, 10, 20, 30, 20)
    val reassignedPriorities = reassignPriorities(priorities)

    println(reassignedPriorities.contentToString())
}

/**
 * Replaces each priority with its rank among the unique priorities.
 *
 * Example: [40, 10, 20, 30, 20] becomes [4, 1, 2, 3, 2].
 */
fun reassignPriorities(priorities: IntArray): IntArray {
   if(priorities.isEmpty()) return intArrayOf()
    val sorted = priorities.clone()
    val map = HashMap<Int, Int>()
    var rank = 1
    for(key in priorities) {
       if(!map.containsKey(key)) {
           map[key] = rank
           rank++
       }
    }
    var result = IntArray(priorities.size)
    for(i in priorities.indices) {
        result[i] = map[priorities[i]]!!
    }
    return result
}
