package leetCode84

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