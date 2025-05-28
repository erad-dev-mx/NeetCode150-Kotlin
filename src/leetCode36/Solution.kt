package leetCode36

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