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

// Test cases
fun main() {
    val solution = Solution()

    val temps1 = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println("Output: ${solution.dailyTemperatures(temps1).joinToString()}")

    val temps2 = intArrayOf(30, 40, 50, 60)
    println("Output: ${solution.dailyTemperatures(temps2).joinToString()}")

    val temps3 = intArrayOf(30, 60, 90)
    println("Output: ${solution.dailyTemperatures(temps3).joinToString()}")

    val temps4 = intArrayOf(90, 80, 70, 60, 50)
    println("Output: ${solution.dailyTemperatures(temps4).joinToString()}")

    val temps5 = intArrayOf(70, 71, 70, 71, 70)
    println("Output: ${solution.dailyTemperatures(temps5).joinToString()}")
}
