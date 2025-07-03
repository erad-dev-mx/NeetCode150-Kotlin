package leetCode150

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