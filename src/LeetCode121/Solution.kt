package LeetCode121

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