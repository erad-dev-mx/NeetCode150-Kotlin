package leetCode49

/**
 * https://leetcode.com/problems/group-anagrams/
 * Time complexity: O(N * K log K)
 * Space complexity: O(N * K)
 * This approach uses a map to group anagrams together.
 * */

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return emptyList()

        val map = mutableMapOf<String, MutableList<String>>()

        for (s in strs) {
            val sorted = s.toCharArray().sorted()
            val key = sorted.joinToString("")

            map.getOrPut(key) { mutableListOf() }.add(s)
        }

        return map.values.toList()
    }
}

// Test cases
fun main() {
    val solution = Solution()

    // Test case 1
    val input1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result1 = solution.groupAnagrams(input1)
    println(result1) // Expected: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

    // Test case 2
    val input2 = arrayOf("")
    val result2 = solution.groupAnagrams(input2)
    println(result2) // Expected: [[""]]

    // Test case 3
    val input3 = arrayOf("a")
    val result3 = solution.groupAnagrams(input3)
    println(result3) // Expected: [["a"]]
}