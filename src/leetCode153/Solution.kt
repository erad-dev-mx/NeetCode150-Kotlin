package leetCode153

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var ans = nums[0]

        if (nums.size == 1) return ans

        while (left <= right) {
            if (nums[left] < nums[right]) {
                ans = minOf(ans, nums[left])
                break
            }

            val mid = left + (right - left) / 2
            ans = minOf(ans, nums[mid])
            if (nums[left] <= nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return ans
    }
}