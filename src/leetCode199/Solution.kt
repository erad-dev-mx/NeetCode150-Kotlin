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