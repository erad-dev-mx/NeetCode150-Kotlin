package leetCode76

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Time Complexity: O(S+T)
 * Space Complexity: O(S+T)
 * This is a sliding window approach
 * */


class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty() || s.length < t.length) return ""

        val mapT = mutableMapOf<Char, Int>()

        for (i in t.indices) {
            mapT[t[i]] = mapT.getOrDefault(t[i], 0) + 1
        }

        var required = mapT.size
        var left = 0
        var right = 0
        var create = 0
        var ans = intArrayOf(-1, 0, 0)
        var subStringMap = mutableMapOf<Char, Int>()

        while (right < s.length) {
            var c = s[right]
            val count = subStringMap.getOrDefault(c, 0)
            subStringMap[c] = count + 1

            if (mapT.contains(c) && subStringMap[c] == mapT[c]) {
                create++;
            }

            while (left <= right && required == create) {
                c = s[left]
                if (ans[0] == -1 || ans[0] >= right - left + 1) {
                    ans[0] = right - left + 1
                    ans[1] = left
                    ans[2] = right
                }
                subStringMap[c] = subStringMap[c]!! - 1
                if (mapT.containsKey(c) && subStringMap[c]!! < mapT[c]!!) {
                    create--
                }
                left++
            }
            right++
        }

        return if (ans[0] == -1) "" else s.substring(ans[1], ans[2] + 1)
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val s1 = "ADOBECODEBANC"
    val t1 = "ABC"
    val result1 = solution.minWindow(s1, t1)
    println("Result 1: $result1")

    val s2 = "A"
    val t2 = "AA"
    val result2 = solution.minWindow(s2, t2)
    println("Result 2: $result2")

    val s3 = "ABC"
    val t3 = "ABC"
    val result3 = solution.minWindow(s3, t3)
    println("Result 3: $result3")
}