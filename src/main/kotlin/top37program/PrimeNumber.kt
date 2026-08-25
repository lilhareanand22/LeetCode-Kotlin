package top37program

fun main() {
    val result = isPrime(7)
    println(result)
}

fun isPrime(num: Int): Boolean {
  if (num < 2) {
      return false
  }
  if(num == 2) {
      return true
  }
  if(num % 2 == 0) {
      return false
  }
  var divisor = 3
  while(divisor <= num/divisor)   {
      if(num % divisor == 0) {
          return false
      }
      divisor += 2
  }

    return true

}
