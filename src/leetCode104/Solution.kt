package leetCode104

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        } else {
            val maxLeft = maxDepth(root.left)
            val maxRight = maxDepth(root.right)

            return maxOf(maxLeft, maxRight) + 1
        }
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
    //       3
    //      / \
    //     9  20
    //       /  \
    //      15   7
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val solution = Solution()
    val depth = solution.maxDepth(root)

    println(depth)
}
