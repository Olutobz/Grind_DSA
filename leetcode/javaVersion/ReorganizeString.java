package javaVersion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * Return any possible rearrangement of s or return "" if not possible.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "aab"
 * Output: "aba"
 *
 * Example 2:
 * Input: s = "aaab"
 * Output: ""
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *  </pre>
 * </blockquote>
 */

public class ReorganizeString {
    /* Intuition:
       1. count letter appearances and store in hash[] or map
       2. find the letter with most occurrence
       3. put the letter into even index numbers (0, 2, 4...) in a char array
       4. put the rest into the array
    */

    // TC -> O(n), SC -> O(n + 26)
    public String reorganizeString(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int max = 0, maxChar = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;
        while (freq[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx += 2;
            freq[maxChar]--;
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }

        return String.valueOf(res);
    }

    // TC -> O(n), SC -> O(n)
    public String reorganizeStringII(String s) {
        if (s == null || s.length() == 1) return s;

        Map<Character, Integer> map = new HashMap<>();
        char maxChar = s.charAt(0);
        int len = s.length();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > map.get(maxChar)) {
                maxChar = ch;
            }
        }

        if (map.get(maxChar) > (len + 1) / 2) return "";

        int i = 0;
        char[] result = new char[len];
        while (i < len && map.get(maxChar) > 0) {
            result[i] = maxChar;
            map.put(maxChar, map.get(maxChar) - 1);
            i += 2;
        }

        for (Character ch : map.keySet()) {
            while (map.get(ch) > 0) {
                if (i >= len)
                    i = 1;
                result[i] = ch;
                map.put(ch, map.get(ch) - 1);
                i += 2;
            }
        }

        return new String(result);
    }
}
