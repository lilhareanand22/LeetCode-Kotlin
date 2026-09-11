package top37program

// This a classic maximum height of a triangle problem

//If Mona has n chocolate
//
//        h(h+1)/2 <= n


fun maximumHeight(n: Int) : Int {
    var height = 0
    var choclateUsed = 0
    while(choclateUsed + height + 1 <= n) {
        height++
        choclateUsed += height
    }
    return height
}
fun maximumWithSQRT(n: Int) : Int {

    return ((Math.sqrt(1.0 + 8.0 * n) -1)/2).toInt()
}

fun main() {
    val n = 8
    val result = maximumWithSQRT(n)
    println("Maximum possible height: $result")
}