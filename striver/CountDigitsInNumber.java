/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02 May 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * <blockquote>
 * <pre>
 * Example 1:
 * Input:N = 12345
 * Output:5
 * Explanation:  The number 12345 has 5 digits.
 *
 * Example 2:
 * Input:N = 7789
 * Output: 4
 * Explanation: The number 7789 has 4 digits.
 * </pre>
 * </blockquote>
 */
public class CountDigitsInNumber {

    // TC -> O(1), SC -> O(1)
    public static int countDigits(int digits) {
        return (int) Math.log10(digits) + 1;
    }

    // TC -> O(log n), SC -> O(1)
    public static int countDigitsII(int digits) {
        int count = 0;
        while (digits > 0) {
            digits = digits / 10;
            count++;
        }
        return count;
    }
}
