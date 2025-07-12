package leetCode74

/**
 * https://leetcode.com/problems/binary-search/
 * Time Complexity: O(log (m * n))
 * Space Complexity: O(1)
 * */

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size // rows
        val n = matrix[0].size // cols

        var left = 0
        var right = m * n - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midVal = matrix[mid / n][mid % n] // Convert 1D index to 2D coordinates: row = mid / n, column = mid % n

            if (midVal == target) {
                return true
            } else if (midVal < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return false
    }
}