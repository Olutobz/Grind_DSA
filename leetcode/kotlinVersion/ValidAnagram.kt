package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 16, September 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters?
 * How would you adapt your solution to such a case?
 * </pre>
 * </blockquote>
 */


// TC -> O(nlogn), SC -> O(n)
fun isAnagram(s: String, t: String): Boolean {
    if (s.isEmpty() && t.isEmpty()) {
        return true
    } else if (s.isEmpty() || t.isEmpty()) {
        return false
    } else if (s.length != t.length) {
        return false
    }

    val s1 = s.toCharArray()
    val t1 = t.toCharArray()
    s1.sort()
    t1.sort()

    return s1.contentEquals(t1)
}

// TC -> O(n), SC -> O(n)
fun isAnagramII(s: String, t: String): Boolean {
    if (s.isEmpty() && t.isEmpty()) {
        return true
    } else if (s.isEmpty() || t.isEmpty()) {
        return false
    } else if (s.length != t.length) {
        return false
    }

    val sMap = mutableMapOf<Char, Int>()
    val tMap = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        sMap.put(s[i], sMap.getOrDefault(s[i], 0) + 1)
        tMap.put(t[i], tMap.getOrDefault(t[i], 0) + 1)
    }

    return sMap == tMap
}

// TC -> O(n), SC -> O(n)
fun isAnagramIII(s: String, t: String): Boolean {
    if (s.isEmpty() && t.isEmpty()) {
        return true
    } else if (s.isEmpty() || t.isEmpty()) {
        return false
    } else if (s.length != t.length) {
        return false
    }

    val map = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
        map[t[i]] = map.getOrDefault(t[i], 0) - 1
    }

    for (value in map.values) {
        if (value != 0) return false
    }

    return true
}

// TC -> O(n), SC -> O(1)
fun isAnagramIV(s: String, t: String): Boolean {
    if (s.isEmpty() && t.isEmpty()) {
        return true
    } else if (s.isEmpty() || t.isEmpty()) {
        return false
    } else if (s.length != t.length) {
        return false
    }

    val freq = IntArray(26)
    for (ch in s) {
        freq[ch - 'a']++
    }
    for (ch in t) {
        freq[ch - 'a']--
    }

    for (count in freq) {
        if (count != 0) return false
    }

    return true
}

// TC -> O(n), SC -> O(1)
fun isAnagramVI(s: String, t: String): Boolean {
    if (s.isEmpty() && t.isEmpty()) {
        return true
    } else if (s.isEmpty() || t.isEmpty()) {
        return false
    } else if (s.length != t.length) {
        return false
    }

    val freq = IntArray(26)
    for (ch in s) {
        freq[ch - 'a']++
    }

    for (ch in t) {
        freq[ch - 'a']--
    }

    return freq.all { it == 0 }
}

fun main() {
    print("hello you")
}
