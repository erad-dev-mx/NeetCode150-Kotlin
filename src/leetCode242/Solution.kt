package leetCode242

// https://leetcode.com/problems/valid-anagram/

// Time complexity: O(n)
// Space complexity: O(1)
// This approach uses a fixed-size array of size 26 (for lowercase English letters) to count the occurrences of each character in both strings.


class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val count = IntArray(26)

        for (i in s.indices) {
            count[s[i] - 'a']++
            count[t[i] - 'a']--
        }

        for (i in count.indices) {
            if (count[i] != 0) return false
        }

        return true
    }
}

// Test cases
fun main() {
    val solution = Solution()

    // Test case 1
    val s1 = "anagram"
    val t1 = "nagaram"
    println(solution.isAnagram(s1, t1)) // Expected output: true

    // Test case 2
    val s2 = "rat"
    val t2 = "car"
    println(solution.isAnagram(s2, t2)) // Expected output: false

    // Additional test cases
    val s3 = "listen"
    val t3 = "silent"
    println(solution.isAnagram(s3, t3)) // Expected output: true

    val s4 = "hello"
    val t4 = "world"
    println(solution.isAnagram(s4, t4)) // Expected output: false
}