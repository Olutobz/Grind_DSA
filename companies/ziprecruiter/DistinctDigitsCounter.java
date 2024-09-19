package ziprecruiter;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 18, September 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given a range of numbers (left, right), both ends inclusive 100 <= left <= right <= 999,
 * count the number of three-digit numbers having all three digits pairwise distinct (meaning no two digits are the same).
 * It is guaranteed all numbers within a range have exactly 3 digits
 * <p>
 * <blockquote>
 * <pre>
 * Example: left = 876, right = 890
 * output = 3
 * </pre>
 * </blockquote>
 */

public class DistinctDigitsCounter {

    // TC -> O(n), SC -> O(1)
    public static int countDistinctDigitNumbers(int left, int right) {
        int count = 0;

        for (int num = left; num <= right; num++) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int ones = num % 10;

            if (hundreds != tens && hundreds != ones && tens != ones) {
                count++;
            }
        }

        return count;
    }
}
