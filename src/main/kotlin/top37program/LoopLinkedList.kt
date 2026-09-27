package top37program



fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3
    node3.next = node1  // Creates a cycle

    println(hasCycle(node1))
}

class ListNode(val value: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while(fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if(slow == fast) {
            return true
        }
    }
    return false
}