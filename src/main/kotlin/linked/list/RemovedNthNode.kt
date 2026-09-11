package linked.list

class ListNode1(var `val`: Int) {
    var next: ListNode1? = null
}


/**
 * Goal:
 * Remove the nth node from the end of a singly linked list and return the
 * updated head of the list.
 *
 * Algorithm:
 * 1. Create a dummy node before the head to handle removing the first node.
 * 2. Move the fast pointer n nodes ahead of the slow pointer.
 * 3. Move both pointers one node at a time until fast reaches the last node.
 * 4. Remove the node after slow by updating slow.next.
 * 5. Return dummy.next.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    fun removeNthFromEnd(
        head: ListNode1?,
        n: Int
    ): ListNode1? {

        val dummy = ListNode1(0)
        dummy.next = head

        var slow = dummy
        var fast = dummy

        // Move fast n steps ahead
        repeat(n) {
            fast = fast.next!!
        }

        // Move both pointers
        while (fast.next != null) {
            slow = slow.next!!
            fast = fast.next!!
        }

        // Remove the nth node from the end
        slow.next = slow.next?.next

        return dummy.next
    }
}

fun main() {
    println("Goal: Remove the nth node from the end of a singly linked list.")
    println()
    println("Algorithm: Remove the nth node from the end of a linked list")
    println("1. Create a dummy node before the head.")
    println("2. Move the fast pointer n nodes forward.")
    println("3. Move slow and fast together until fast reaches the last node.")
    println("4. Skip the node after slow, removing the nth node from the end.")
    println()

    val head = ListNode1(1).apply {
        next = ListNode1(2).apply {
            next = ListNode1(3).apply {
                next = ListNode1(4).apply {
                    next = ListNode1(5)
                }
            }
        }
    }

    print("Original list: ")
    printList(head)

    val result = Solution().removeNthFromEnd(head, 2)

    print("After removing the 2nd node from the end: ")
    printList(result)
}

fun printList(head: ListNode1?) {
    var current = head
    while (current != null) {
        print(current.`val`)
        current = current.next
        if (current != null) print(" -> ")
    }
    println()
}
