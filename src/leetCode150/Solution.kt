package leetCode150

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            if (isOperator(token)) {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(applyOperator(token, a, b))
            } else {
                stack.addLast(token.toInt())
            }
        }

        return stack.removeLast()
    }

    private fun isOperator(operator: String): Boolean {
        return operator in listOf("+", "-", "/", "*")
    }

    private fun applyOperator(operator: String, a: Int, b: Int): Int {
        return when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> -1
        }
    }
}

// Test cases
fun main() {
    val solution = Solution()

    test(solution, arrayOf("2", "1", "+", "3", "*"))
    test(solution, arrayOf("4", "13", "5", "/", "+"))
    test(solution, arrayOf("3", "4", "+"))
    test(solution, arrayOf("5"))
    test(
        solution,
        arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
    )
}

fun test(solution: Solution, tokens: Array<String>) {
    val result = solution.evalRPN(tokens)
    println("Result: $result")
}