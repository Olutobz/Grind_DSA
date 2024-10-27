import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string
 * and change it to any other uppercase English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter
 * you can get after performing the above operations.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * </pre>
 * </blockquote>
 */

public class LongestRepeatingCharacterReplacement {

    // TC -> O(N), SC -> O(26)
    public int characterReplacementII(String s, int k) {
        if (s == null || s.isEmpty()) return 0;

        int[] freq = new int[26];
        int left = 0, maxFreq = 0;
        int maxChars = 0;

        for (int right = 0; right < s.length(); right++) {
            char currCh = s.charAt(right);
            freq[currCh - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currCh - 'A']);
            int charsToReplace = (right - left + 1) - maxFreq;
            if (charsToReplace > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxChars = Math.max(maxChars, right - left + 1);

        }

        return maxChars;
    }

    // TC -> O(N), SC -> O(N)
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            int lettersToChange = (right - left + 1) - maxFreq;

            if (lettersToChange > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }


}