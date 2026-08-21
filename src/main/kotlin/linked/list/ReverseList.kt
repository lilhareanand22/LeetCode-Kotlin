package linked.list



class ListNode(
    var value: Int = 0,
    var next: ListNode? = null
)

fun reverseList(head: ListNode?): ListNode? {

    /**
     * Goal:
     * Reverse the links in a singly linked list and return the new head.
     *
     * Algorithm:
     * 1. Keep `prev` as the part of the list that has already been reversed.
     * 2. Keep `current` as the node currently being processed.
     * 3. Save `current.next` before changing the link.
     * 4. Point `current.next` to `prev`, then move both pointers forward.
     * 5. When `current` becomes null, `prev` is the new head.
     *
     * Time complexity: O(n), where n is the number of nodes.
     * Space complexity: O(1), because the list is reversed in place.
     */

    var prev: ListNode? = null
    var current = head

    while (current != null) {

        // Save the remaining list before reversing the current link.
        val next = current.next

        // Reverse the current node's pointer.
        current.next = prev

        // Move the reversed-list boundary and current pointer forward.
        prev = current

        current = next
    }

    return prev
}

fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    val reversedHead = reverseList(head)

    val values = mutableListOf<Int>()
    var current = reversedHead
    while (current != null) {
        values += current.value
        current = current.next
    }

    println(values.joinToString(" -> "))
}
