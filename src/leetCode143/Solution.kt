package leetCode143

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null) return

        var slow = head
        var fast = head

        // Finding middle width slow & fast pointer
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Reverse the second part
        var prev: ListNode? = null
        var curr = slow?.next
        slow?.next = null

        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        // Merge two parts
        var first = head
        var second = prev

        while (second != null) {
            val temp1 = first?.next
            val temp2 = second.next

            first?.next = second
            second.next = temp1

            first = temp1
            second = temp2
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}