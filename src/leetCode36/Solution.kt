package leetCode36

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Time complexity: O(1)
 * Space complexity: O(1)
 * This approach uses hashing to track the numbers seen in each row, column, and 3x3 box.
 * */

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val boxes = Array(9) { HashSet<Char>() }

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val value = board[r][c]

                if (value == '.') continue

                if (rows[r].contains(value)) {
                    return false
                }
                rows[r].add(value)

                if (cols[c].contains(value)) {
                    return false
                }
                cols[c].add(value)

                val boxIndex = (r / 3) * 3 + (c / 3)
                if (boxes[boxIndex].contains(value)) {
                    return false
                }
                boxes[boxIndex].add(value)
            }
        }

        return true
    }
}

// Test cases
fun main() {
    val solution = Solution()
    val board1 = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '9', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(solution.isValidSudoku(board1)) // Output: true

    val board2 = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '9', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(solution.isValidSudoku(board2)) // Output: false
}