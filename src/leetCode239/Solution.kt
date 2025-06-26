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