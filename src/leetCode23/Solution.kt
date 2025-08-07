package leetCode23

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<Int>()

        for (list in lists) {
            var node = list
            while (node != null) {
                minHeap.add(node.`val`)
                node = node.next
            }
        }

        val dummy = ListNode(1)
        var merge = dummy
        while (minHeap.isNotEmpty()) {
            merge.next = ListNode(minHeap.remove())
            merge = merge.next!!
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


