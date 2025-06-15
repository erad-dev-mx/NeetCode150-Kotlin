package leetCode11

/**
 * https://leetcode.com/problems/container-with-most-water/
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a Two-Pointer technique
 * */

class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            val width = right - left
            val area = minOf(height[right], height[left]) * width
            max = maxOf(max, area)

            if (height[left] <= height[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7),
        intArrayOf(5, 5, 5, 5, 5),
        intArrayOf(1, 2, 3, 4, 5, 6),
        intArrayOf(6, 5, 4, 3, 2, 1)
    )

    for ((index, heights) in testCases.withIndex()) {
        val result = solution.maxArea(heights)
        println("Case ${index + 1}: $result")
    }
}