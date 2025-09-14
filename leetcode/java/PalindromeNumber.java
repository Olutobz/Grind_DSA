package java;

/**
 * Given an integer x, return true if x is a palindrome and false otherwise.
 *
 * <blockquote>
 * <pre>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * </pre>
 * </blockquote>
 */

public class PalindromeNumber {

    // TC -> O(logN), SC -> O(1);
    private boolean isPalindrome(int n) {
        if (n < 0) return false;

        int original = n;
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return original == reversed;
    }

    // TC -> O(logN), SC -> O(1);
    private boolean isPalindromeII(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        int res = 0;
        while (n > res) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return n == res || n == res / 10;
    }

    // TC -> O(N), SC -> O(N);
    private boolean isPalindromeIII(int n) {
        if (n < 0) return false;
        String temp = Integer.toString(n);
        int start = 0, end = temp.length() - 1;
        while (start < end) {
            if (temp.charAt(start) != temp.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
