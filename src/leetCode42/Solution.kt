package leetCode42

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a Two-Pointer technique
 * */

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

// Test cases
fun main() {
    val solution = Solution()

    val heights1 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println("Trapped water ${solution.trap(heights1)}")

    val heights2 = intArrayOf(4, 2, 0, 3, 2, 5)
    println("Trapped water ${solution.trap(heights2)}")

    val heights3 = intArrayOf(2, 0, 2)
    println("Trapped water ${solution.trap(heights3)}")

    val heights4 = intArrayOf(0, 0, 0, 0, 0)
    println("Trapped water ${solution.trap(heights4)}")
}