package basic_math; /**
 * Created by Onikoyi Damola Olutoba
 * DATE: 25, June 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given a number N. Count the number of digits in N which evenly divide N.
 * <p>
 * Note :- Evenly divides means whether N is divisible by a digit i.e. leaves a remainder 0 when divided.
 *
 * <blockquote>
 * <pre>
 * Input:
 * N = 12
 * Output: 2
 * Explanation:
 * 1, 2 both divide 12 evenly
 *
 * Input:
 * N = 23
 * Output: 0
 * Explanation:
 * 2 and 3, none of them
 * divide 23 evenly
 * </pre>
 * </blockquote>
 */

public class EvenlyDivides {

    // TC -> O(LogN), SC -> O(1)
    private int evenlyDivide(int n) {
        int count = 0;
        int originalNumber = n;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit > 0) {
                if (originalNumber % lastDigit == 0) count++;
            }
            n /= 10;
        }
        return count;
    }
}
