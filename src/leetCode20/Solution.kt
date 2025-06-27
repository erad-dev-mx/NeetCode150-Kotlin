package leetCode20

class Solution {
    fun isValid(s: String): Boolean {
        val mappedBrackets = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        val stack = ArrayDeque<Char>()

        for (c in s) {
            if (c !in mappedBrackets) {
                stack.addLast(c)
            } else {
                if (stack.isEmpty() || stack.removeLast() != mappedBrackets[c]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}