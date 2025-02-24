package javaVersion;

/**
 * Given a string s, return the longest
 * palindromic
 * substring in s.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * </pre>
 * </blockquote>
 */

public class LongestPalindromicSubstring {
    // TC -> O(N^2), SC -> O(1)
    public String longestPalindrome(String s) {
        String res = "";
        int currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = i - currLen - 1;
            int evenLen = i - currLen;
            if (isPalindrome(s, oddLen, i)) {
                res = s.substring(oddLen, i + 1);
                currLen += 2;
            } else if (isPalindrome(s, evenLen, i)) {
                res = s.substring(evenLen, i + 1);
                currLen++;
            }
        }

        return res;
    }

    // TC -> O(N), SC -> O(1)
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
