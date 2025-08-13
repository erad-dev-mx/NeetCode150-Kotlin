package leetCode543

class Solution {
    var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        getHeight(root!!)
        return maxDiameter
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = getHeight(node.left)
        val rightHeight = getHeight(node.right)

        maxDiameter = maxOf(maxDiameter, leftHeight + rightHeight)

        return 1 + maxOf(leftHeight, rightHeight)
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

// Test case
fun main() {
    //        1
    //       / \
    //      2   3
    //     / \
    //    4   5
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    val solution = Solution()
    val diameter = solution.diameterOfBinaryTree(root)
    println(diameter)  // 3
}