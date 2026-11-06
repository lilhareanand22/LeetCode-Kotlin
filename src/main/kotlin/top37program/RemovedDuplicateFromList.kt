package top37program



fun main() {
    val result = removeDuplicates(listOf(1, 2, 2, 3, 4, 4, 5))
    println(result)  // Output: [1, 2, 3, 4, 5]
}

fun removeDuplicates(numbers: List<Int>): List<Int> {

    //return numbers.distinct()
    val arraySet = HashSet<Int>()
    val uniqArrayList = ArrayList<Int>()
    for(num in numbers) {
        if(arraySet.add(num)) {
            uniqArrayList.add(num)
        }
    }
    return uniqArrayList
}
