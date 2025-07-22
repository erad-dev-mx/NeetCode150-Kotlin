package leetCode21

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy = ListNode(1)
        var merge = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                merge.next = l1
                l1 = l1.next
            } else {
                merge.next = l2
                l2 = l2.next
            }
            merge = merge.next!!
        }

        merge.next = l1 ?: l2

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