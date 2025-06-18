package leetCode3

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time Complexity: O(n)
 * Space Complexity: O(min(N,M)
 * This approach uses a sliding window and Two-Pointer technique.
 * */


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