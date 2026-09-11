package linked.list

class ListNode1(var `val`: Int) {
    var next: ListNode1? = null
}


/** Definition for singly-linked list. */

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
    val head = ListNode1(1).apply {
        next = ListNode1(2).apply {
            next = ListNode1(3).apply {
                next = ListNode1(4).apply {
                    next = ListNode1(5)
                }
            }
        }
    }

    val result = Solution().removeNthFromEnd(head, 2)

    var current = result
    while (current != null) {
        print(current.`val`)
        current = current.next
        if (current != null) print(" -> ")
    }
}
