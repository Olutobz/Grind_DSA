package recursion;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class BasicRecursion {
    static int count = 0;

    // TC -> O(3), SC -> O(3) [O(n) -> if we count for n number of integers]
    static void integerCounter() {
        if (count == 3) return;
        System.out.println(count);
        count++;
        integerCounter();
    }

    // TC -> O(n), SC -> O(n)
    static void repeatName(int i, int n) {
        if (i > n) return;
        System.out.println("Toba");
        repeatName(i + 1, n);
    }

    // TC -> O(i), SC -> O(i)
    static void backTrackIntegerCounter(int i) {
        if (i < 1) return;
        backTrackIntegerCounter(i - 1);
        System.out.println(i);
    }

    // TC -> O(n), SC -> O(1)
    static void sumOfFirstNNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of first '" + n + "' natural numbers: " + sum);
    }

    // TC -> O(1), SC -> O(1)
    static void sumOfFirstNNaturalNumbersII(int n) {
        int sum = n * (n + 1) / 2;
        System.out.println("Sum of first '" + n + "' natural numbers: " + sum);
    }

    // TC -> O(n), SC -> O(n)
    static void sumOfFirstNNaturalNumbersRecursively(int n, int sum) {
        if (n < 1) {
            System.out.println("Recursion -> Sum of first natural numbers: " + sum);
            return;
        }
        sumOfFirstNNaturalNumbersRecursively(n - 1, sum + n);
    }

    // TC -> O(n), SC -> O(n)
    static int sumOfFirstNNaturalNumbersRecursivelyII(int n) {
        if (n < 1) return 0;
        return n + sumOfFirstNNaturalNumbersRecursivelyII(n - 1);
    }

    // TC -> O(n), SC -> O(1)
    static int factorial(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    // TC -> O(n), SC -> O(n)
    static int factorialRecursively(int n) {
        if (n == 0) return 1;
        return n * factorialRecursively(n - 1);
    }

    public static void main(String[] args) {
        integerCounter();
        System.out.println();
        repeatName(1, 3);
        System.out.println();
        backTrackIntegerCounter(3);
        System.out.println();
        sumOfFirstNNaturalNumbers(5);
        sumOfFirstNNaturalNumbersII(5);
        sumOfFirstNNaturalNumbersRecursively(5, 0);
        System.out.println("Sum of N natural number: " + sumOfFirstNNaturalNumbersRecursivelyII(5));
        System.out.println("The iterative factorial of " + 5 + " is " + factorial(5));
        System.out.println("The recursive factorial of " + 5 + " is " + factorialRecursively(5));
    }

}
