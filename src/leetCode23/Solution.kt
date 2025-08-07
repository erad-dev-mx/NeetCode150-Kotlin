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

// Test cases
fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(5)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)

    val l3 = ListNode(2)
    l3.next = ListNode(6)

    val lists = arrayOf<ListNode?>(l1, l2, l3)

    val solution = Solution()
    var merged = solution.mergeKLists(lists)

    while (merged != null) {
        print("${merged.`val`} ")
        merged = merged.next
    }
}
