package leetCode567

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1Map = IntArray(26)
        val s2Map = IntArray(26)

        for (i in s1.indices) {
            s1Map[s1[i] - 'a']++
            s2Map[s2[i] - 'a']++
        }

        for (i in 0 until s2.length - s1.length) {
            if (matches(s1Map, s2Map)) return true
            s2Map[s2[i + s1.length] - 'a'] // adding new char in window
            s2Map[s2[i] - 'a']-- // removing old char from window
        }

        return matches(s1Map, s2Map)
    }

    private fun matches(arr1: IntArray, arr2: IntArray): Boolean {
        for (i in 0..25) {
            if (arr1[i] != arr2[i]) return false
        }
        return true
    }
}