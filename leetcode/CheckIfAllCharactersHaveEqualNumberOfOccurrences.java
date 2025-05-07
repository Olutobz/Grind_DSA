/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, May 2025
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return true if s is a good string, or false otherwise.
 * <p>
 * A string s is good if all the characters that appear in s have the same
 * number of occurrences (i.e., the same frequency
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abacbc"
 * Output: true
 * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
 *
 * Example 2:
 * Input: s = "aaabb"
 * Output: false
 * Explanation: The characters that appear in s are 'a' and 'b'.
 * 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    // TC -> O(N), SC -> O(1)
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int prev = freq[s.charAt(0) - 'a'];
        for (int num : freq) {
            if (num != 0 && num != prev) {
                return false;
            }
        }

        return true;
    }

    // TC -> O(N), SC -> O(N)
    public boolean areOccurrencesEqualII(String s) {
        if (s.length() == 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int freq = map.get(s.charAt(0));
        for (char key : map.keySet()) {
            if (map.get(key) != freq)
                return false;
        }

        return true;
    }
}

