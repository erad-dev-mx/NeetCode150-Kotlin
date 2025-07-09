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

// Test cases
fun main() {
    val solution = Solution()

    val result1 = solution.carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3))
    println("Fleet: $result1")

    val result2 = solution.carFleet(10, intArrayOf(3), intArrayOf(3))
    println("Fleet: $result2")

    val result3 = solution.carFleet(100, intArrayOf(0, 2, 4), intArrayOf(4, 2, 1))
    println("Fleet: $result3")

    val result4 = solution.carFleet(15, intArrayOf(6, 8), intArrayOf(3, 2))
    println("Fleet: $result4")
}