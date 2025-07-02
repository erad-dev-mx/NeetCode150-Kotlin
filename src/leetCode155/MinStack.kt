package leetCode155

/**
 * https://leetcode.com/problems/min-stack/submissions/1683280973/
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * */

class MinStack() {
    private var head: Node? = null

    fun push(`val`: Int) {
        if (head == null) {
            head = Node(`val`, `val`, null)
        } else {
            val min = minOf(`val`, head!!.min)
            head = Node(`val`, min, head)
        }
    }

    fun pop() {
        head = head!!.next
    }

    fun top(): Int {
        return head!!.value
    }

    fun getMin(): Int {
        return head!!.min
    }

    private data class Node(val value: Int, val min: Int, val next: Node?)
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */