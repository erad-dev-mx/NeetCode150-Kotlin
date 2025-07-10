package leetCode84

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val n = heights.size
        val stack = ArrayDeque<Int>()

        for (i in 0..n) {
            val currentHeight = if (i == n) 0 else heights[i]
            while (stack.isNotEmpty() && currentHeight < heights[stack.last()]) {
                val height = heights[stack.removeLast()]
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.addLast(i)
        }

        return maxArea
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val h1 = intArrayOf(2, 1, 5, 6, 2, 3)
    println("Max area: ${solution.largestRectangleArea(h1)}")

    val h2 = intArrayOf(2, 4)
    println("Max area: ${solution.largestRectangleArea(h2)}")

    val h3 = intArrayOf(6, 2, 5, 4, 5, 1, 6)
    println("Max area: ${solution.largestRectangleArea(h3)}")

    val h4 = intArrayOf(1, 2, 3, 4, 5)
    println("Max area: ${solution.largestRectangleArea(h4)}")

    val h5 = intArrayOf(5, 4, 3, 2, 1)
    println("Max area: ${solution.largestRectangleArea(h5)}")
}