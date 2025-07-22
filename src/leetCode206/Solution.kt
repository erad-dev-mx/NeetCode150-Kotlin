package leetCode206

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var curr: ListNode? = head
        var prev: ListNode? = null

        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        return prev
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