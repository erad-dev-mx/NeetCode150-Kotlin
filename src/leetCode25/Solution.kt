package leetCode25

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var headNode = head
        var ptr: ListNode? = headNode
        var kTail: ListNode? = null
        var newHead: ListNode? = null

        while (ptr != null) {
            var count = 0
            ptr = headNode

            // Check if there is at least k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next
                count++
            }

            // If there are k nodes, switch
            if (count == k) {
                val revHead = reverseLinkedList(headNode, k)

                // New head if its first switch
                if (newHead == null) {
                    newHead = revHead
                }

                // Connect prev group with this
                if (kTail != null) {
                    kTail.next = revHead
                }

                // Update kTail
                kTail = headNode

                // Moving headNode to start for next group
                headNode = ptr
            }
        }

        // Connect remaining
        if (kTail != null) {
            kTail.next = headNode
        }

        return newHead ?: headNode
    }

    private fun reverseLinkedList(head: ListNode?, k: Int): ListNode? {
        var headNode = head
        var newHead: ListNode? = null
        var remainig = k

        while (remainig > 0 && headNode != null) {
            val nextNode = headNode.next
            headNode.next = newHead
            newHead = headNode
            headNode = nextNode
            remainig--
        }

        return newHead
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
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    val solution = Solution()

    println("Original list")
    printList(head)

    val k = 2
    val result = solution.reverseKGroup(head, k)

    println("After list")
    printList(result)
}

fun printList(head: ListNode?) {
    var curr = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}