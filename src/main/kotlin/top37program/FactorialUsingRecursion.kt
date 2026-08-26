package top37program




fun main(){
    val result = factorial(5)
    println(result)
}

fun factorial(num: Int) : Int {
    return if (num <= 1) 1 else num * factorial(num - 1)
}

