package leetCode125

class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) {
                left++
            }
            while (left < right && !s[right].isLetterOrDigit()) {
                right--
            }

            while (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val testCases = listOf(
        "", "a", "A man, a plan, a canal: Panama", "race a car", ".,!@#$", "MadAm", "12321", "12345"
    )

    for (input in testCases) {
        val result = solution.isPalindrome(input)
        println("Input: \"$input\" Result: $result")
    }
}