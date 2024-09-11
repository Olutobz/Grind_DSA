/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 11, September 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * An integer  is a divisor of an integer  if the remainder of .
 * <p>
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor.
 * Count the number of divisors occurring within the integer.
 *
 * <blockquote>
 * <pre>
 * Example
 * n = 124
 * Check whether 1, 2 and 4 are divisors of 124. All 3 numbers divide evenly into 124 so return 3.
 * n = 111
 * Check whether 1, 1, and 1 are divisors of 111. All 3 numbers divide evenly into 111 so return 3.
 * n 10
 * Check whether 1 and 0 are divisors of 10. 1 is, but 0 is not. Return 1.
 * </pre>
 * </blockquote>
 */

public class FindDigits {

    // TC -> O(log n), SC -> O(1)
    public static int findDigits(int n) {
        int originalNum = n;
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0 && originalNum % digit == 0) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
