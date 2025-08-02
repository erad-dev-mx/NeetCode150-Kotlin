package leetCode287

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        // Find the intersection point
        while (fast != slow) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        // Find the entrance of "cycle"
        slow = 0
        while (fast != slow) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return fast
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(1, 3, 4, 2, 2)
    println("Duplicate: ${solution.findDuplicate(nums1)}")

    val nums2 = intArrayOf(3, 1, 3, 4, 2)
    println("Duplicate: ${solution.findDuplicate(nums2)}")

    val nums3 = intArrayOf(1, 1)
    println("Duplicate: ${solution.findDuplicate(nums3)}")

    val nums4 = intArrayOf(1, 1, 2)
    println("Duplicate: ${solution.findDuplicate(nums4)}")

    val nums5 = intArrayOf(3, 4, 3, 2, 1, 5, 6)
    println("Duplicate: ${solution.findDuplicate(nums5)}")
}