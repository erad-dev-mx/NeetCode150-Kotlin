package leetCode704

/**
 * https://leetcode.com/problems/binary-search/
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * */

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val middle = left + (right - left)  / 2
            if (nums[middle] == target) {
                return middle
            } else if (nums[middle] > target) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return -1
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(-1, 0, 3, 5, 9, 12)
    println("Index: ${solution.search(nums1, 9)}")

    val nums2 = intArrayOf(-1, 0, 3, 5, 9, 12)
    println("Index: ${solution.search(nums2, 2)}")

    val nums3 = intArrayOf(1, 3, 5, 7, 9)
    println("Index: ${solution.search(nums3, 1)}")

    val nums4 = intArrayOf(1, 3, 5, 7, 9)
    println("Index: ${solution.search(nums4, 9)}")

    val nums5 = intArrayOf(1)
    println("Index: ${solution.search(nums5, 1)}")
}