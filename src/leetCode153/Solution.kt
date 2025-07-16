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

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(3, 4, 5, 1, 2)
    println("Min: ${solution.findMin(nums1)}")

    val nums2 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println("Min: ${solution.findMin(nums2)}")

    val nums3 = intArrayOf(11, 13, 15, 17)
    println("Min: ${solution.findMin(nums3)}")

    val nums4 = intArrayOf(2, 1)
    println("Min: ${solution.findMin(nums4)}")

    val nums5 = intArrayOf(1)
    println("Min: ${solution.findMin(nums5)}")
}
