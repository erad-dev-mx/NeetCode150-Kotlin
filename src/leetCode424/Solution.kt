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

// Test cases
fun main() {
    val solution = Solution()

    val s1 = "ABAB"
    val k1 = 2
    println(solution.characterReplacement(s1, k1)) // Output: 4

    val s2 = "AABABBA"
    val k2 = 1
    println(solution.characterReplacement(s2, k2)) // Output: 4

    val s3 = "AAAA"
    val k3 = 2
    println(solution.characterReplacement(s3, k3)) // Output: 4

    val s4 = "ABCDE"
    val k4 = 1
    println(solution.characterReplacement(s4, k4)) // Output: 2
}