package Blind75.LinkedList

fun reorderList(head: ListNode?) {

        if (head?.next == null) return

        // Step 1: Find middle
        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: Split and reverse second half
        var second = slow?.next
        slow?.next = null

        var prev: ListNode? = null
        var current = second

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        second = prev

        // Step 3: Merge two halves
        var first = head

        while (second != null) {

            val temp1 = first?.next
            val temp2 = second.next

            first?.next = second
            second.next = temp1

            first = temp1
            second = temp2
        }
    }

fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

    print("Original list: ")
    printList(head)

    reorderList(head)

    print("Reordered list: ")
    printList(head)
}
