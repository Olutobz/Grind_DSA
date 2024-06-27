package basicMath;
/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 25, June 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given two integers N1 and N2, find their greatest common divisor.
 * <p>
 * The Greatest Common Divisor of any two integers is the largest number that divides both integers.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: N1 = 9, N2 = 12
 * Output: 3
 * Explanation:Factors of 9: 1, 3 and 9
 * Factors of 12: 1, 2, 3, 4, 6, 12
 * Common Factors: 1, 3 out of which 3 is the greatest hence it is the GCD.
 *
 * Example 2:
 * Input:N1 = 20, N2 = 15
 * Output: 5
 * Explanation:Factors of 20: 1, 2, 4, 5
 * Factors of 15: 1, 3, 5
 * Common Factors: 1, 5 out of which 5 is the greatest hence it is the GCD.
 * </pre>
 * </blockquote>
 */

public class FindGcdOfTwoNumbers {

    // TC -> O(min(n1,n2)), SC -> O(1)
    private static int findGcd(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
