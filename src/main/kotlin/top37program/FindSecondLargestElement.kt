package top37program



fun main() {
    val result = secondLargest(arrayOf(1, 3, 4, 2, 5))
    println(result)
}

fun secondLargest(num:Array<Int>) : Int? {
//    val sortedArr = num.sorted()
//    if (sortedArr.size > 1) {
//        return sortedArr[sortedArr.size - 2]
//    } else {
//        return null
//    }


    if (num.size < 2) {
        return null
    }

    var largest: Int? = null
    var secondLargest: Int? = null

    for (value in num) {
        if (largest == null || value >= largest!!) {
            secondLargest = largest
            largest = value
        } else if (secondLargest == null || value > secondLargest!!) {
            secondLargest = value
        }
    }

    return secondLargest
}

/*
Dry run for arrayOf(1, 3, 4, 2, 5):

Initial values:
largest = null
secondLargest = null

Value     largest     secondLargest
1         1           null
3         3           1
4         4           3
2         4           3
5         5           4

Final result:
secondLargest = 4

Output:
4
*/
