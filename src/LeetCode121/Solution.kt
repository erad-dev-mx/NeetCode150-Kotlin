package LeetCode121

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