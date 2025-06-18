package leetCode3

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var ans = 0
        var left = 0
        var set = mutableSetOf<Char>()

        for (right in s.indices) {
            while (set.contains(s[right])) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            ans = maxOf(ans, right - left + 1)
        }

        return ans
    }
}