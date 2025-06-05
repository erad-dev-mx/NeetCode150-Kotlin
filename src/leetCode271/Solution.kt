package leetCode271

class Solution {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        if (strs.isEmpty()) return 258.toChar().toString()

        val separate = 257.toChar().toString()

        val sb = StringBuilder()
        for (s in strs) {
            sb.append(s)
            sb.append(separate)
        }
        sb.deleteCharAt(sb.length - 1)

        return sb.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        if (s == 258.toChar().toString()) return emptyList()

        val separate = 257.toChar().toString()

        return s.split(separate)
    }
}

// Your code will be called as such:
// val solution = Solution()
// val encoded = solution.encode(listOf("hello", "world"))

// Test cases
fun main() {
    val solution = Solution()
    val encoded = solution.encode(listOf("hello", "world"))
    println(encoded) // Output: "hello257world"

    val decoded = solution.decode(encoded)
    println(decoded) // Output: [hello, world]

    val emptyEncoded = solution.encode(emptyList())
    println(emptyEncoded) // Output: "258"

    val emptyDecoded = solution.decode(emptyEncoded)
    println(emptyDecoded) // Output: []
}