package leetCode128

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()

        var longestSub = 1
        for (num in numSet) {
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentSub = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    currentSub++
                }

                longestSub = maxOf(longestSub, currentSub)
            }
        }

        return longestSub
    }
}