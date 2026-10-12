package Blind75.LinkedList



fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    val middle = middleNode(head)

    println("Middle node: ${middle?.value}")
}

internal fun middleNode(head:ListNode?): ListNode? {
    var fast = head
    var slow = head
    while(fast != null && fast.next!= null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}