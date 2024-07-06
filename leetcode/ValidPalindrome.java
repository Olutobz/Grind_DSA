/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * <blockquote>
 * <pre>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * </pre>
 * </blockquote>
 */

public class ValidPalindrome {

    // TC -> O(N), SC -> O(1)
    private static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    // TC -> O(N), SC -> O(N)
    private static boolean isPalindromeII(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPalindromeIII(String s, int idx) {
        if (idx >= s.length() / 2) return true;
        if (Character.toLowerCase(s.charAt(idx))
                != Character.toLowerCase(s.charAt(s.length() - 1 - idx))) {
            return false;
        }
        return isPalindromeIII(s, idx + 1);
    }
}
