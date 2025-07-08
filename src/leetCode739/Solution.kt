package leetCode739

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val answer = IntArray(n)
        val stack = ArrayDeque<Int>()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val index = stack.removeLast()
                answer[index] = i - index
            }
            stack.addLast(i)
        }

        return answer
    }
}