package leetCode100

/**
 * https://leetcode.com/problems/same-tree/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true

        if (p == null || q == null) return false

        if (p.`val` != q.`val`) return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
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
    // Tree 1
    val p = TreeNode(1)
    p.left = TreeNode(2)
    p.right = TreeNode(3)

    // Tree 2
    val q = TreeNode(1)
    q.left = TreeNode(2)
    q.right = TreeNode(3)

    val solution = Solution()
    println(solution.isSameTree(p, q)) // Expected: true

    // Another test
    val p2 = TreeNode(1)
    p2.left = TreeNode(2)

    val q2 = TreeNode(1)
    q2.right = TreeNode(2)

    println(solution.isSameTree(p2, q2)) // Expected: false
}