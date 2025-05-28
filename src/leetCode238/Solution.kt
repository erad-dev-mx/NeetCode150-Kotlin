package leetCode238

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