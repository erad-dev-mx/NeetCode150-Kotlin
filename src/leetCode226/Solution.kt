package leetCode226

import java.util.LinkedList
import java.util.Queue

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

// Test cases
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)

    val solution = Solution()
    val inverted = solution.invertTree(root)

    printLevelOrder(inverted) // 4 7 2 9 6 3 1
}

fun printLevelOrder(root: TreeNode?) {
    if (root == null) return
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        print("${node.`val`} ")
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}