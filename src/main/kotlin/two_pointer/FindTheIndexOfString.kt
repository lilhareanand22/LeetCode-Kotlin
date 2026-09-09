package two_pointer

fun strStr(haystack: String, needle: String): Int {

    if (needle.isEmpty()) return 0

    for (i in 0..haystack.length - needle.length) {

        var j = 0

        while (j < needle.length &&
            haystack[i + j] == needle[j]) {
            j++
        }

        if (j == needle.length) {
            return i
        }
    }

    return -1
}

fun main() {
    val str = "badluckbad"
    val target = "luck"

    println(findTargetIndexWithSubString(str, target))
}


fun findTargetIndex(str: String, target: String): Int {
    return str.indexOf(target)
}

fun findTargetIndexWithSubString(str: String, target: String): Int {

    for (i in 0..str.length - target.length) {
        if (str.substring(i, i + target.length) == target) {
            return i
        }
    }

    return -1
}