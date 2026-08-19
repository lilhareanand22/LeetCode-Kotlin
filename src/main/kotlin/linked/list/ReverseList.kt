package linked.list



class ListNode(
    var value: Int = 0,
    var next: ListNode? = null
)

fun reverseList(head: ListNode?): ListNode? {

    var prev: ListNode? = null
    var current = head

    while (current != null) {

        val next = current.next

        current.next = prev

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
