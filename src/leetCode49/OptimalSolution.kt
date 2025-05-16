package leetCode49

// https://leetcode.com/problems/group-anagrams/

// Time Complexity: O(N * K)
// Space Complexity: O(N * K)

class OptimalSolution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return emptyList()

        val ansMap = mutableMapOf<String, MutableList<String>>()
        val count = IntArray(26)

        for (s in strs) {
            count.fill(0)

            for (c in s) {
                count[c - 'a']++
            }

            val sb = StringBuilder()
            for (i in 0 until 26) {
                sb.append("#")
                sb.append(count[i])
            }

            val key = sb.toString()
            ansMap.getOrPut(key) { mutableListOf() }.add(s)
        }

        return ansMap.values.toList()
    }
}

// Test cases
fun main() {
    val solution = OptimalSolution()

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