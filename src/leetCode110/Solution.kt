package leetCode110

import kotlin.math.abs

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        val leftHeight = getHeight(root.left)
        val rightHeight = getHeight(root.right)

        if (abs(leftHeight - rightHeight) > 1) return false

        return isBalanced(root.left) && isBalanced(root.right)
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = getHeight(node.left)
        val rightHeight = getHeight(node.right)

        return maxOf(leftHeight, rightHeight) + 1
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

fun main() {
    // Tree:
    //      3
    //     / \
    //    9  20
    //       / \
    //      15  7
    // Expected: true

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val solution = Solution()
    val result = solution.isBalanced(root)
    println(result) // Expected: true
}