package leetCode2



class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var ans = dummy
        var carry = 0
        var p1 = l1
        var p2 = l2

        while (p1 != null || p2 != null || carry != 0) {
            val x = p1?.`val` ?: 0
            val y = p2?.`val` ?: 0
            val sum = x + y + carry

            carry = sum / 10
            ans.next = ListNode(sum % 10)
            ans = ans.next!!

            p1 = p1?.next
            p2 = p2?.next
        }

        return dummy.next
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
