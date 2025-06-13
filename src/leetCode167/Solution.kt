package leetCode167

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Time complexity: O(N)
 * Space complexity: O(1)
 * This approach uses Two-Pointer technique
 * */

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]

            when {
                sum > target -> right--
                sum < target -> left++
                else -> return intArrayOf(left + 1, right + 1)
            }
        }

        return null!!
    }
}

// Test cases
fun main() {
    val solution = Solution()
    val numbers = intArrayOf(2, 7, 11, 15)
    val target = 9

    val result = solution.twoSum(numbers, target)

    println("Result: ${result.joinToString(", ")}")
}