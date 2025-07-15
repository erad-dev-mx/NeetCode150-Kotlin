package leetCode875


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