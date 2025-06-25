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