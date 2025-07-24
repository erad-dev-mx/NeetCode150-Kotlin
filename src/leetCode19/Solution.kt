package leetCode19

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */


class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(1)
        dummy.next = head;

        var front: ListNode? = dummy;
        var back: ListNode? = dummy;

        for (i in 0..n) {
            front = front?.next
        }

        while (front != null) {
            front = front.next
            back = back?.next
        }
        back?.next = back.next?.next

        return dummy.next;
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