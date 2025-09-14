package java;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation:
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class FirstUniqueCharacterInAString {

    // TC -> O(N), SC -> O(1);
    public int firstUniqCharII(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[(s.charAt(i) - 'a')] == 1) {
                return i;
            }
        }

        return -1;
    }

    // TC -> O(N), SC -> O(N);
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // TC -> O(N^2), SC -> O(1);
    public int firstUniqCharIII(String s) {
        if (s == null || s.isEmpty()) return -1;
        for (char c : s.toCharArray()) {
            int index = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (index == lastIndex)
                return index;
        }
        return -1;
    }

}
