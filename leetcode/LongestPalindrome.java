import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome that can be built with those letters.
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * </pre>
 * </blockquote>
 */

public class LongestPalindrome {

    // TC -> O(N), SC -> O(1)
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] charsFreq = new int[52];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                charsFreq[ch - 'a']++;
            } else {
                charsFreq[ch - 'A' + 26]++;
            }
        }

        for (int charNum : charsFreq) {
            count += charNum / 2;
        }

        count = count * 2;
        return Math.min(s.length(), count + 1);
    }

    // TC -> O(N), SC -> O(N)
    public int longestPalindromeII(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int res : map.values()) {
            count += res / 2;
        }
        count = count * 2;
        return Math.min(s.length(), count + 1);
    }

    // TC -> O(N), SC -> O(N)
    public int longestPalindromeIII(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }

        if (!set.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }
}
