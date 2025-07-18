package leetCode4

import kotlin.math.min

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/"
 * Time Complexity: O(log min(m, n))
 * Space Complexity: O(1)
 * */

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

        val x = nums1.size
        val y = nums2.size
        var start = 0
        var end = x

        while (start <= end) {
            val partX = (start + end) / 2
            val partY = (x + y + 1) / 2 - partX

            val xLeft = if (partX == 0) Int.MIN_VALUE else nums1[partX - 1]
            val xRight = if (partX == x) Int.MAX_VALUE else nums1[partX]
            val yLeft = if (partY == 0) Int.MIN_VALUE else nums2[partY - 1]
            val yRight = if (partY == y) Int.MAX_VALUE else nums2[partY]

            if (xLeft <= yRight && yLeft <= xRight) {
                return if ((x + y) % 2 == 0) {
                    (maxOf(xLeft, yLeft) + min(xRight, yRight)) / 2.0
                } else {
                    maxOf(xLeft, yLeft).toDouble()
                }
            } else if (xLeft > yRight) {
                end = partX - 1
            } else {
                start = partX + 1
            }
        }

        return 0.0
    }
}