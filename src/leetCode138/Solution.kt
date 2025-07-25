package leetCode138

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */

class Solution {
    val visited = HashMap<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        if (visited.containsKey(node)) {
            return visited[node]
        }

        val newNode = Node(node.`val`)
        visited[node] = newNode

        newNode.next = copyRandomList(node.next)
        newNode.random = copyRandomList(node.random)

        return newNode
    }
}

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}