package leetCode287

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        // Find the intersection point
        while (fast != slow) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        // Find the entrance of "cycle"
        slow = 0
        while (fast != slow) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return fast
    }
}
