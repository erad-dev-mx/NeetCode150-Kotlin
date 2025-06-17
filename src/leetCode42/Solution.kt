package leetCode42


class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var total = 0
        var leftMax = height[left]
        var rightMax = height[right]

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = maxOf(leftMax, height[left])
                if (leftMax - height[left] > 0) {
                    total = total + leftMax - height[left]
                }
                left++
            } else {
                rightMax = maxOf(rightMax, height[right])
                if (rightMax - height[right] > 0) {
                    total = total + rightMax - height[right]
                }
                right--
            }
        }

        return total
    }
}