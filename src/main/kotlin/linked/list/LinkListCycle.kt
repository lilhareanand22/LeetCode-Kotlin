package linked.list




fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while(fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if(slow == fast) {
            return true
        }
    }
    return false
}

fun main() {
    // Positive input: 1 -> 2 -> 3 -> 2 ...
    val cycleNode1 = ListNode(1)
    val cycleNode2 = ListNode(2)
    val cycleNode3 = ListNode(3)

    cycleNode1.next = cycleNode2
    cycleNode2.next = cycleNode3
    cycleNode3.next = cycleNode2

    println("Positive input has cycle: ${hasCycle(cycleNode1)}")

    // Negative input: 1 -> 2 -> 3 -> null
    val nonCycleHead = ListNode(1, ListNode(2, ListNode(3)))

    println("Negative input has cycle: ${hasCycle(nonCycleHead)}")
}
