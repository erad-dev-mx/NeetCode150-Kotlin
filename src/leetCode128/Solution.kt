package leetCode128

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Time complexity: O(N)
 * Space complexity: O(N)
 * This approach uses a HashSet to store the numbers and find the longest consecutive sequence.
 * */

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()

        var longestSub = 1
        for (num in numSet) {
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentSub = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    currentSub++
                }

                longestSub = maxOf(longestSub, currentSub)
            }
        }

        return longestSub
    }
}

// Test cases
fun main() {
    val solution = Solution()
    println(solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))) // Output: 4
    println(solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 1))) // Output: 9
    println(solution.longestConsecutive(intArrayOf())) // Output: 0
    println(solution.longestConsecutive(intArrayOf(1))) // Output: 1
}