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

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(1, 2, 3, 4)
    println(solution.productExceptSelf(nums1).contentToString()) // Output: [24, 12, 8, 6]

    val nums2 = intArrayOf(-1, 1, 0, -3, 3)
    println(solution.productExceptSelf(nums2).contentToString()) // Output: [0, 0, 9, 0, 0]

    val nums3 = intArrayOf(1)
    println(solution.productExceptSelf(nums3).contentToString()) // Output: [1]

    val nums4 = intArrayOf(1, 2)
    println(solution.productExceptSelf(nums4).contentToString()) // Output: [2, 1]
}