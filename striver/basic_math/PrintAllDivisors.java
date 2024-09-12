package basic_math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 27, June 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an integer n, return all divisors of n.
 * <p>
 * A divisor of an integer n is a positive integer that divides n without leaving a remainder.
 * In other words, if n is divisible by another integer without any remainder,
 * then that integer is considered a divisor of n.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: n = 36
 * Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]
 * Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
 *
 * Example 2:
 * Input: n = 12
 * Output: [1, 2, 3, 4, 6, 12]
 * Explanation: The divisors of 12 are 1, 2, 3, 4, 6, 12.
 * </pre>
 * </blockquote>
 */

public class PrintAllDivisors {

    // TC -> O(N), SC -> O(1) [excluding output array]
    private static int[] getAllDivisors(int n) {
        int[] divisors = new int[n];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors[index] = i;
            }
            index++;
        }

        return divisors;
    }

    // TC -> O(sqrt(N)), SC -> O(1) [excluding output array]
    private static List<Integer> getAllDivisorsII(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                divisors.add(i);

                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        return divisors;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            if (num != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static void printList(List<Integer> list) {
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(getAllDivisors(36));
        printArray(getAllDivisors(12));
        System.out.println("-------------------");
        printList(getAllDivisorsII(36));
        printList(getAllDivisorsII(12));
    }
}
