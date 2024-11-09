import java.util.HashMap;
import java.util.Map;

/**
 * A string was given. I needed to find the first non-repeating counter.
 * If there is no such character, return 0.
 *
 * <blockquote>
 * <pre>
 * Input: s= "asubsebusapd"
 * Output: e
 *
 * Input: s = "aabbcc"
 * Output: 0
 * </pre>
 * </blockquote>
 */

public class FirstNonRepeatingCharacterInAString {

    // TC -> O(N), SC -> O(1);
    public char findFirstUniqueChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[(s.charAt(i) - 'a')] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

    // TC -> O(N), SC -> O(N);
    public char firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

}
