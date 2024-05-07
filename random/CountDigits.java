/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02 May 2024
 * EMAIL: damexxey94@gmail.com
 */
public class CountDigits {
    public int countDigits(Long digits) {
        int count = 0;
        while (digits != 0) {
            digits = digits / 10;
            count++;
        }
        return count;
    }

    /* O(1)
     */
    public int countDigitsII(Long digits) {
        return (int) Math.floor(Math.log10(digits) + 1);
    }
}
