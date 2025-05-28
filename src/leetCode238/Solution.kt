package leetCode238

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * This approach a two-pass algorithm to calculate the product of all elements except the current one.
 * */

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        var pre = 1
        var post = 1

        for (i in nums.indices) {
            result[i] = pre
            pre = nums[i] * pre
        }

        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * post
            post = post * nums[i]
        }

        return result
    }
}