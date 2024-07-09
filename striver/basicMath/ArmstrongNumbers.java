package basicMath;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 27, June 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.
 * <p>
 * An Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input:N = 153
 * Output:True
 * Explanation: 1^3 + 5^3 + 3^3= 1 + 125 + 27 = 153
 *
 * Example 2:
 * Input:N = 371
 * Output: True
 * Explanation: 3^3 + 7^3 + 1^3 = 27 + 343 + 1 = 371
 * </pre>
 * </blockquote>
 */

public class ArmstrongNumbers {

    // TC -> O(log n) or O(d), SC -> O(1)
    private static boolean isArmstrong(int n) {
        int sum = 0;
        int num = n;
        int noOfDigits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, noOfDigits);
            num /= 10;
        }

        return sum == n;
    }

    // TC -> O(n), SC -> O(n)
    private static boolean isArmstrongII(int n) {
        String numString = Integer.toString(n);
        int noOfDigits = numString.length();
        int sum = 0;

        for (int i = 0; i < numString.length(); i++) {
            int digit = numString.charAt(i) - '0';
            sum += (int) Math.pow(digit, noOfDigits);
        }

        return sum == n;
    }

}
