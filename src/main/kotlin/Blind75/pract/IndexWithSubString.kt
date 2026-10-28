package Blind75.pract



fun main() {
    val str = "badluckbad"
    val target = "luck"

    println(findTargetIndexWithSubString1(str, target))
}

fun findTargetIndexWithSubString1(str: String, target: String) : Int{
    for(i in 0 ..str.length - target.length) {
        if(str.substring(i, i + target.length) == target) {
            return i
        }
    }

   return  -1
}
