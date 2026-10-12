package Blind75.LinkedList

fun main() {
    // Input lists: 1 -> 3 -> 5 and 2 -> 4 -> 6
    val list1 = ListNode(1, ListNode(3, ListNode(5)))
    val list2 = ListNode(2, ListNode(4, ListNode(6)))

    val mergedList = mergeTwoListsNode(list1, list2)

    var current = mergedList
    val values = mutableListOf<Int>()

    while (current != null) {
        values += current.value
        current = current.next
    }

    println("Merged list: ${values.joinToString(" -> ")}")
}
internal fun mergeTwoListsNode(list1:ListNode?, list2:ListNode?) : ListNode? {
    val dummy = ListNode(0)
    var current: ListNode? = dummy
    var first = list1
    var second = list2
    while(first != null && second!=null) {
        if(first.value <= second.value) {
            current?.next = first
            first = first.next
        } else {
            current?.next = second
            second = second.next
        }
        current = current?.next
    }
    current?.next = first?:second
   return dummy.next
}