import linked.list.ListNode

fun mergeTwoLists(
    list1: ListNode?,
    list2: ListNode?
): ListNode? {

    val dummy = ListNode()
    var tail = dummy

    var first = list1
    var second = list2

    while (first != null && second != null) {

        if (first.value <= second.value) {
            tail.next = first
            first = first.next
        } else {
            tail.next = second
            second = second.next
        }

        tail = tail.next!!
    }

    // Attach remaining nodes
    if (first != null) {
        tail.next = first
    } else {
        tail.next = second
    }

    return dummy.next
}

fun main() {
    // Input lists: 1 -> 3 -> 5 and 2 -> 4 -> 6
    val list1 = ListNode(1, ListNode(3, ListNode(5)))
    val list2 = ListNode(2, ListNode(4, ListNode(6)))

    val mergedList = mergeTwoLists(list1, list2)

    var current = mergedList
    val values = mutableListOf<Int>()

    while (current != null) {
        values += current.value
        current = current.next
    }

    println("Merged list: ${values.joinToString(" -> ")}")
}
