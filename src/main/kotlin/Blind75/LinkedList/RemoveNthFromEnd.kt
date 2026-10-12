package Blind75.LinkedList




internal fun removedNthFromEnd(head:ListNode?, n:Int): ListNode? {
    var dummy = ListNode(0)
    dummy.next = head
    var fast = head
    var slow = head
    repeat(n) {
        fast = fast?.next
    }
    while(fast!= null && fast.next != null) {
        slow = slow?.next
        fast = fast.next
    }
    slow?.next = slow.next?.next
   return dummy.next
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    print("Original list: ")
    printList(head)

    val result = removedNthFromEnd(head, 2)

    print("After removing the 2nd node from the end: ")
    printList(result)
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print(current.value)
        current = current.next
        if (current != null) print(" -> ")
    }
    println()
}