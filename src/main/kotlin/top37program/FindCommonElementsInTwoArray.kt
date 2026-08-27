package top37program




fun main() {
    val result = findCommonElements(arrayOf(1, 2, 3, 4), arrayOf(3, 4, 5, 6))
    println(result.joinToString())
}


/*
   Dry run:
   arr1 = [1, 2, 3, 4]
   arr2 = [3, 4, 5, 6]

   1. Find the largest value:
      maxValue = 6

   2. Create BooleanArrays of size 7.
      Indexes represent the numbers 0 to 6.
      presentInFirstArray = [false, false, false, false, false, false, false]
      alreadyAddInArray   = [false, false, false, false, false, false, false]

   3. Mark the numbers from arr1:
      number 1 -> presentInFirstArray[1] = true
      number 2 -> presentInFirstArray[2] = true
      number 3 -> presentInFirstArray[3] = true
      number 4 -> presentInFirstArray[4] = true

      presentInFirstArray = [false, true, true, true, true, false, false]

   4. Check the numbers from arr2:
      number 3 -> exists in arr1, add 3 to result
      number 4 -> exists in arr1, add 4 to result
      number 5 -> does not exist in arr1, skip
      number 6 -> does not exist in arr1, skip

   5. Final result = [3, 4]
*/
fun findCommonElements(arr1: Array<Int>, arr2: Array<Int>): IntArray {
    var maxValue = 0
    for(number in arr1) {
        if (number > maxValue ) maxValue = number
    }
    for(number in arr2) {
        if(number > maxValue) maxValue = number
    }
    var presentInFirstArray = BooleanArray(maxValue + 1)
    var alreadyAddInArray = BooleanArray(maxValue + 1)
    var result = ArrayList<Int>()
    for(num in arr1) {
        presentInFirstArray[num] = true
    }

    for (number in arr2) {
        if (presentInFirstArray[number] && !alreadyAddInArray[number]) {
            result.add(number)
            alreadyAddInArray[number] = true
        }
    }
    return result.toIntArray()
}
