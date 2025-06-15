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