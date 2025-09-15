package java;

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
        if (s == null || s.isEmpty()) return false;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char currStart = Character.toLowerCase(s.charAt(start));
            char currEnd = Character.toLowerCase(s.charAt(end));
            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (currStart != currEnd) {
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
        if (s == null || s.isEmpty()) return false;

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
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

    // TC -> O(N), SC -> O(N)
    private static boolean isPalindromeIII(String s, int start, int end) {
        if (s == null || s.isEmpty()) return false;

        while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
        while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
        if (start >= s.length() / 2) return true;
        else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
            return false;
        } else {
            return isPalindromeIII(s, start + 1, end - 1);
        }
    }
}
