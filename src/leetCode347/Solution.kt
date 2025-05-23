package leetCode347

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 * This approach uses a HashMap to count the frequency of each number and a min-heap to keep track of the top k frequent elements.
 * */

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k == nums.size) return nums

        val count = mutableMapOf<Int, Int>()

        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }

        val heap = PriorityQueue<Int>(compareBy { count[it] })

        for (n in count.keys) {
            heap.add(n)
            if (heap.size > k) {
                heap.poll()
            }
        }

        val ans = IntArray(k)
        for (i in 0 until k) {
            ans[i] = heap.poll()
        }

        return ans
    }
}

// Test cases
fun main() {
    val solution = Solution()
    println(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString()) // Output: [1, 2]
    println(solution.topKFrequent(intArrayOf(1), 1).contentToString()) // Output: [1]
    println(solution.topKFrequent(intArrayOf(1, 2), 2).contentToString()) // Output: [1, 2]
}