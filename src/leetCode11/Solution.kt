package leetCode11

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