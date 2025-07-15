package leetCode875

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * Time complexity: O(n Log(m)) Where n is the number of piles and m is the maximum value in piles
 * Space Complexity: O(1)
 * */

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull() ?: 1

        while (left < right) {
            val mid = left + (right - left) / 2
            if (canFinish(piles, mid, h)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun canFinish(piles: IntArray, speed: Int, h: Int): Boolean {
        var hours = 0
        for (pile in piles) {
            hours += (pile + speed - 1) / speed
        }

        return hours <= h
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val p1 = intArrayOf(3, 6, 7, 11)
    println("Min speed: ${solution.minEatingSpeed(p1, 8)}")

    val p2 = intArrayOf(30, 11, 23, 4, 20)
    println("Min speed: ${solution.minEatingSpeed(p2, 5)}")

    val p3 = intArrayOf(30, 11, 23, 4, 20)
    println("Min speed: ${solution.minEatingSpeed(p3, 6)}")

    val p4 = intArrayOf(312_884_470)
    println("Min speed: ${solution.minEatingSpeed(p4, 968_709_470)}")

    val p5 = intArrayOf(1, 1, 1, 1)
    println("Min speed: ${solution.minEatingSpeed(p5, 4)}")
}
