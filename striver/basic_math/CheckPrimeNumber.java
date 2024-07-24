package basic_math;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02, July 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an integer N, check whether it is prime or not.
 * A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input:N = 2
 * Output:True
 * Explanation: 2 is a prime number because it has two divisors: 1 and 2 (the number itself).
 *
 * Example 2:
 * Input:N =10
 * Output: False
 * Explanation: 10 is not prime, it is a composite number because it has 4 divisors: 1, 2, 5 and 10.
 * </pre>
 * </blockquote>
 */

public class CheckPrimeNumber {

    // TC -> O(N), SC -> O(1)
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count == 2;
    }

    // TC -> O(sqrt(N)), SC -> O(1)
    private static boolean isPrimeII(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // TC -> O(sqrt(N)), SC -> O(1)
    private static boolean isPrimeIII(int n) {
        if (n < 2) return false;
        int count = 0;
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count == 2;
    }

    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 5, 8, 10, 17, 19, 20};
        for (int num : testNumbers) {
            System.out.println("Test1: Is " + num + " prime? " + isPrime(num));
            System.out.println("Test2: Is " + num + " prime? " + isPrimeII(num));
            System.out.println("Test3: Is " + num + " prime? " + isPrimeIII(num));
            System.out.println();
        }
    }
}
