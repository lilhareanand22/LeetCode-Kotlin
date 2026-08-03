package intervals

import kotlin.collections.sorted

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )

    val mergedIntervals = merge(intervals)
    println(mergedIntervals.joinToString(prefix = "[", postfix = "]") { it.contentToString() })
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
if(intervals.isEmpty()) return emptyArray()

 intervals.sortBy{it[0]}
 val result = mutableListOf<IntArray>()
 result.add(intervals[0])

 for(i in 1 until intervals.size) {
     val current = intervals[i]
     val last = result.last()
     if(current[0] <= last[1] ) {
         last[1] = maxOf(last[1], current[1])
     } else {
        result.add(intervals[i])
     }
 }
    return result.toTypedArray()

}
