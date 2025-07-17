package leetCode121

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var profit = 0

        for (price in prices) {
            if (price < min) {
                min = price
            }

            profit = maxOf(profit, price - min)
        }

        return profit
    }
}

// Test cases
fun main() {
    val solution = Solution()

    val prices1 = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Max benefit: ${solution.maxProfit(prices1)}")

    val prices2 = intArrayOf(5, 5, 5, 5, 5)
    println("Max benefit: ${solution.maxProfit(prices2)}")

    val prices3 = intArrayOf(1, 2, 3, 4, 5)
    println("Max benefit: ${solution.maxProfit(prices3)}")
}