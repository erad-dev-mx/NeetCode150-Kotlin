package shortExercises.characterFrequencyCounting

/**
 * Exercise 1: Count the Frequency of Each Letter
 * Goal: Count how many times each lowercase letter appears in a string.
 * */

class Exercise1 {
    fun countLetters(s: String): IntArray {
        val freq = IntArray(26)

        for (c in s) {
            freq[c - 'a']++
        }

        return freq
    }
}

/**
 * Exercise 2: Check if Two Strings Have the Same Letters (Anagrams)
 * Goal: Return true if two strings have exactly the same letters with the same frequency.
 * */

class Exercise2 {
    fun areAnagrams(a: String, b: String): Boolean {
        val freqA = IntArray(26)
        val freqB = IntArray(26)

        for (c in a) freqA[c - 'a']++
        for (c in b) freqB[c - 'a']++

        return freqA.contentEquals(freqB)
    }
}

/**
 * Exercise 3: First Non-Repeating Character
 * Goal: Given a string, return the first character that appears only once.
 * */

class Exercise3 {
    fun firstUniqueChar(s: String): Char {
        val freq = IntArray(26)

        for (c in s) freq[c - 'a']++

        for (i in s) {
            if (freq[i - 'a'] == 1) return i
        }

        return '_'
    }
}

// Test cases
fun main() {
    // Exercise 1
    val exercise1 = Exercise1()
    val result1 = exercise1.countLetters("batman")
    for (i in result1.indices) {
        if (result1[i] > 0) {
            println("${'a' + i}: ${result1[i]}")
        }
    }

    println()

    // Exercise 2
    val exercise2 = Exercise2()
    println(exercise2.areAnagrams("listen", "silent"))
    println(exercise2.areAnagrams("hello", "flash"))

    println()

    // Exercise 3
    val exercise3 = Exercise3()
    println(exercise3.firstUniqueChar("lil"))
    println(exercise3.firstUniqueChar("hackerrank"))
}