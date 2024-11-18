/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class PalindromicSubstrings {

    // TC -> O(N^2), SC -> O(1)
    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length palindromic sub-string
            count += countPalindromes(s, i, i);
            //even length palindromic sub-string
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    // TC -> O(N), SC -> O(1)
    public static int countPalindromes(String str, int end, int start) {
        int count = 0;
        while (end >= 0 && start < str.length()) {
            if (str.charAt(start) != str.charAt(end)) {
                break;
            }
            count++;
            start++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aba"));
        System.out.println(countSubstrings("abba"));
        System.out.println(countSubstrings("akrfa"));
    }
}
