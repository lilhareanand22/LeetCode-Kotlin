package linked.list



fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while( fast != null  && fast.next != null) {
        slow  = slow?.next
        fast = fast.next?.next

    }
    return slow
}

fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    val middle = middleNode(head)

    println("Middle node: ${middle?.value}")
}
