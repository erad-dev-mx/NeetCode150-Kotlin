package leetCode15

/**
 * https://leetcode.com/problems/3sum/
 * Time complexity: O(N^2) + O(N LogN)
 * Space complexity: O(N)
 * This approach uses a Two-Pointer technique
 * */

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableListOf<List<Int>>()

        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result)
            }
        }

        return result
    }

    fun twoSum(nums: IntArray, i: Int, result: MutableList<List<Int>>) {
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum < 0 -> left++
                sum > 0 -> right--
                else -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++
                    }
                }
            }
        }
    }
}