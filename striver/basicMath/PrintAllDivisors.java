package basicMath;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 27, June 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an integer N, return all divisors of N.
 * <p>
 * A divisor of an integer N is a positive integer that divides N without leaving a remainder.
 * In other words, if N is divisible by another integer without any remainder,
 * then that integer is considered a divisor of N.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input:N = 36
 * Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]
 * Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
 *
 * Example 2:
 * Input:N =12
 * Output: [1, 2, 3, 4, 6, 12]
 * Explanation: The divisors of 12 are 1, 2, 3, 4, 6, 12.
 * </pre>
 * </blockquote>
 */
public class PrintAllDivisors {

    // TC -> O(N), SC -> O(N)
    private static int[] getAllDivisors(int n) {
        int[] divisors = new int[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors[count] = i;
            }
            count++;
        }
        return divisors;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            if (data != 0) {
                System.out.print(data + " ");
            }
        }
    }

    public static void main(String[] args) {
        printArray(getAllDivisors(36));
    }
}
