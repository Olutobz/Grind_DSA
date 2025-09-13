package java;

/**
 * Given an integer N. Print the Fibonacci series up to the Nth term.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: N = 5
 * Output: 0 1 1 2 3 5
 * Explanation: 0 1 1 2 3 5 is the fibonacci series up to 5th term.(0 based indexing)
 *
 * Example 2:
 * Input: 6
 * Output: 0 1 1 2 3 5 8
 * Explanation: 0 1 1 2 3 5 8 is the fibonacci series upto 6th term.(0 based indexing)
 * </pre>
 * </blockquote>
 */
public class FibonacciNumber {

    // TC -> O(n), SC -> O(1)
    public int fib(int n) {
        if (n <= 1) return n;

        int last = 0;
        int secondToLast = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = last + secondToLast;
            last = secondToLast;
            secondToLast = curr;
        }
        return curr;
    }

    // TC -> O(n), SC -> O(1)
    public int fibII(int n) {
        if (n <= 1) return n;

        int last = 0;
        int secondToLast = 1;
        int curr = 0;
        while (n > 1) {
            curr = last + secondToLast;
            last = secondToLast;
            secondToLast = curr;
            n--;
        }
        return curr;
    }

    // TC -> O(n), SC -> O(n)
    public static int fibIII(int n) {
        if (n == 0) return 0;

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    // TC -> O(2^n), SC -> O(n)
    public static int fibIV(int n) {
        if (n <= 1) return n;
        return fibIV(n - 1) + fibIV(n - 2);
    }

}
