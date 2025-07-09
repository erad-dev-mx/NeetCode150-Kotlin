package leetCode853

/**
 * https://leetcode.com/problems/car-fleet/submissions/
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * */

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        val cars = Array(n) { DoubleArray(2) }

        for (i in 0 until n) {
            cars[i][0] = position[i].toDouble() // Car position
            cars[i][1] = (target - position[i]).toDouble() / speed[i] // Time to reach to the end
        }

        cars.sortByDescending { it[0] }

        var count = 0
        var prevTime = 0.0
        for (car in cars) {
            if (car[1] > prevTime) {
                count++
                prevTime = car[1]
            }
        }

        return count
    }
}