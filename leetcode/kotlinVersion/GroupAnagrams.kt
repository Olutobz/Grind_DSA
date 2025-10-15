package kotlinVersion

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 15, October 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * </pre>
 * </blockquote>
 */


// TC -> O(m * n), SC -> O(n)
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return emptyList()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in strs) {
        val freq = IntArray(26)
        for (ch in word.toCharArray()) {
            freq[ch - 'a']++
        }
        val currWordKey = freq.contentToString()
        if (!map.containsKey(currWordKey)) {
            map[currWordKey] = mutableListOf()
        }
        map[currWordKey]?.add(word)
    }

    return map.values.toList()
}

// TC -> O(m * nlogn), SC -> O(n)
fun groupAnagramsII(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return emptyList()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in strs) {
        val sortedCharArr = word.toCharArray().sortedArray()
        val currWordKey = sortedCharArr.contentToString()
        if (!map.containsKey(currWordKey)) {
            map[currWordKey] = mutableListOf()
        }
        map[currWordKey]?.add(word)
    }

    return map.values.toList()
}