package leetCode424

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a sliding window + Two-Pointer technique.
 * */

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val occurrence = IntArray(26)
        var left = 0
        var ans = 0
        var maxOccurrence = 0

        for (right in s.indices) {
            val charIndex = s[right] - 'A'
            occurrence[charIndex]++
            maxOccurrence = maxOf(maxOccurrence, occurrence[charIndex])

            if (right - left + 1 - maxOccurrence > k) {
                occurrence[s[left] - 'A']--
                left++
            }

            ans = maxOf(ans, right - left + 1)
        }

        return ans
    }
}