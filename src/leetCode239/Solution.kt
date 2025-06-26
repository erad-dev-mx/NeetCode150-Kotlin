package leetCode239

import java.util.Deque
import java.util.LinkedList

/**
 * https://leetcode.com/problems/two-sum/
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 * This is a sliding window approach
 * */

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k <= 0) return intArrayOf()

        val n = nums.size
        val result = IntArray(n - k + 1)
        val deque: Deque<Int> = LinkedList()

        for (i in nums.indices) {
            // Removing indices that are out of the current window
            while (deque.isNotEmpty() && deque.peek() < i - k + 1) {
                deque.poll()
            }

            // Removing indices whose corresponding values are less than nums[i]
            while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast()
            }

            // Adding the current index to the deque
            deque.offer(i)

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]
            }
        }

        return result
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k1 = 3
    val result1 = solution.maxSlidingWindow(nums1, k1)
    println("Result 1: ${result1.joinToString(", ", "[", "]")}")

    val nums2 = intArrayOf(1)
    val k2 = 1
    val result2 = solution.maxSlidingWindow(nums2, k2)
    println("Result 2: ${result2.joinToString(", ", "[", "]")}")

    val nums3 = intArrayOf(9, 11)
    val k3 = 2
    val result3 = solution.maxSlidingWindow(nums3, k3)
    println("Result 3: ${result3.joinToString(", ", "[", "]")}")

    val nums4 = intArrayOf(4, -2)
    val k4 = 2
    val result4 = solution.maxSlidingWindow(nums4, k4)
    println("Result 4: ${result4.joinToString(", ", "[", "]")}")
}