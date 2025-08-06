package leetCode146

class LRUCache(capacity: Int) {

    private inner class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val capacity = capacity
    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        insertAtHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            remove(node)
            insertAtHead(node)
        } else {
            if (map.size == capacity) {
                val toRemove = tail.prev!!
                map.remove(toRemove.key)
                remove(toRemove)
            }
            val newNode = Node(key, value)
            map[key] = newNode
            insertAtHead(newNode)
        }
    }

    // Util functions
    private fun remove(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun insertAtHead(node: Node) {
        node.next = head.next
        head.next?.prev = node
        head.next = node
        node.prev = head
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */