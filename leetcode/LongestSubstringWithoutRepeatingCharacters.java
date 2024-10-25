import java.util.*;


/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * </pre>
 * </blockquote>
 */

public class LongestSubstringWithoutRepeatingCharacters {

    // TC -> O(N), SC -> O(N)
    public int lengthOfLongestSubstringII(String s) {
        if (s == null || s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // TC -> O(N), SC -> O(N)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

    // TC -> O(N), SC -> O(N)
    public int lengthOfLongestSubstringIII(String s) {
        if (s == null || s.isEmpty()) return 0;

        Queue<Character> queue = new LinkedList<>();
        int max = 0;

        for (char ch : s.toCharArray()) {
            while (queue.contains(ch)) {
                queue.poll();
            }
            queue.offer(ch);
            max = Math.max(max, queue.size());
        }
        return max;
    }

}
