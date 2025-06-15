package leetCode1

/**
 * https://leetcode.com/problems/two-sum/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * This approach uses a HashMap to store the indices of the numbers as we iterate through the array.
 * */

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]

            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i) // Return answer
            }
            // Store the index of the current number
            map.put(nums[i], i)
        }

        return intArrayOf(-1, -1)
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    println(solution.twoSum(nums1, target1).contentToString()) // Output: [0, 1]

    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    println(solution.twoSum(nums2, target2).contentToString()) // Output: [1, 2]

    val nums3 = intArrayOf(3, 3)
    val target3 = 6
    println(solution.twoSum(nums3, target3).contentToString()) // Output: [0, 1]
}