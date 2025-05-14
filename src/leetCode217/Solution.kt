package leetCode217

// https://leetcode.com/problems/contains-duplicate/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val seenNumbers = hashSetOf<Int>()

        for (num in nums) {
            if (seenNumbers.contains(num)) {
                return true // Duplicate found
            }
            seenNumbers.add(num)
        }

        return false // No duplicates found
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(1, 2, 3, 1)
    println(solution.containsDuplicate(nums1)) // Output: true

    val nums2 = intArrayOf(1, 2, 3, 4)
    println(solution.containsDuplicate(nums2)) // Output: false

    val nums3 = intArrayOf()
    println(solution.containsDuplicate(nums3)) // Output: false

    val nums4 = intArrayOf(1)
    println(solution.containsDuplicate(nums4)) // Output: false

    val nums5 = intArrayOf(2, 2, 2, 2)
    println(solution.containsDuplicate(nums5)) // Output: true
}