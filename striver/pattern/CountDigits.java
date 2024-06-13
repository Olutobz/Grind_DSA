package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02 May 2024
 * EMAIL: damexxey94@gmail.com
 */
public class CountDigits {

    // TC -> O(1), SC -> O(1)
    public static int countDigits(Long digits) {
        return (int) Math.floor(Math.log10(digits) + 1);
    }

    // TC -> O(log n), SC -> O(1)
    public static int countDigitsII(Long digits) {
        int count = 0;
        while (digits != 0) {
            digits = digits / 10;
            count++;
        }
        return count;
    }
}
