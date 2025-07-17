package leetCode981

import java.util.TreeMap

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 * Time complexity: O(Log(n))
 * Space Complexity: O(k * n)
 * */

class TimeMap() {

    private val map = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { TreeMap() }.put(timestamp, value)
    }

    fun get(key: String, timestamp: Int): String {
        val treeMap = map[key] ?: return ""
        val entry = treeMap.floorEntry(timestamp)
        return entry?.value ?: ""
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */