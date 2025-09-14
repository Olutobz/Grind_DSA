package java;

import java.util.*;

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
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class GroupAnagrams {

    // TC -> O(n * m), SC -> O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            int[] freqArr = new int[26];
            for (char ch : word.toCharArray()) {
                freqArr[ch - 'a']++;
            }

            String currKey = Arrays.toString(freqArr);
            if (!map.containsKey(currKey)) {
                map.put(currKey, new ArrayList<>());
            }
            map.get(currKey).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // TC -> O(m * nlogn), SC -> O(n)
    public List<List<String>> groupAnagramsII(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String currKey = new String(charArr);

            if (!map.containsKey(currKey)) {
                map.put(currKey, new ArrayList<>());
            }
            map.get(currKey).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
