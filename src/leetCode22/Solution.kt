package leetCode22

/**
 * https://leetcode.com/problems/generate-parentheses/
 * */

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()
        backtrack(ans, StringBuilder(), 0, 0, n)

        return ans
    }

    fun backtrack(ans: MutableList<String>, cur: StringBuilder, open: Int, close: Int, max: Int) {
        if (cur.length == max * 2) {
            ans.add(cur.toString())
            return
        }

        if (open < max) {
            cur.append("(")
            backtrack(ans, cur, open + 1, close, max)
            cur.deleteCharAt(cur.length - 1)
        }

        if (close < open) {
            cur.append(")")
            backtrack(ans, cur, open, close + 1, max)
            cur.deleteCharAt(cur.length - 1)
        }
    }
}