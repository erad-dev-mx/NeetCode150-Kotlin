package leetCode347

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
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