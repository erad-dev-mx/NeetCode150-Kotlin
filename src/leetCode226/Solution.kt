package leetCode226

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val right: TreeNode? = invertTree(root.right)
        val left: TreeNode? = invertTree(root.left)

        root.left = right
        root.right = left

        return root
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