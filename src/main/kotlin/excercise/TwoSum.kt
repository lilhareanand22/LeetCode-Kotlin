package excercise



fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    println(twoSumOptimized(nums, target).contentToString())
}

fun twoSumOptimized(nums:IntArray,target:Int) : IntArray {
   val hashMap = HashMap<Int, Int>()
  for(num in nums.indices) {
      val compliment = target - nums[num]
      val index = hashMap[compliment]
      if(index != null) {
          return intArrayOf(index, num)
      }
      hashMap[nums[num]] = num
  }
  return intArrayOf()
}
