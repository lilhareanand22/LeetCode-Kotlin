package Blind75.LinkedList

internal fun reversedLinkList(head: ListNode?) : ListNode? {
    var reversLinkList:ListNode? = null
    var current = head
    while(current != null) {
        var next = current.next
        current.next = reversLinkList
        reversLinkList = current
        current = next
    }
    return reversLinkList
}

fun main() {
    val linkList = ListNode(0,ListNode(1,ListNode(2,ListNode(3, null))))
    val result = reversedLinkList(linkList)
    val value = mutableListOf<Int>()
    var current = result
    while(current!=null) {
        value += current.value
        current = current.next
    }
    println(value.joinToString("->"))
}