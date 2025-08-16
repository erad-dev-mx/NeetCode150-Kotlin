package leetCode199

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val currentNode = queue.poll()
                if (i == levelSize - 1) result.add(currentNode.`val`)
                currentNode.left?.let { queue.add(it) }
                currentNode.right?.let { queue.add(it) }
            }
        }

        return result
    }
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Test cases
fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left?.right = TreeNode(5)
    root1.right?.right = TreeNode(4)

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)

    val solution = Solution()
    println(solution.rightSideView(root1)) // Expected: [1, 3, 4]
    println(solution.rightSideView(root2)) // Expected: [1, 2]
}