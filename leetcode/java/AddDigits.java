package java;

/**
 * <blockquote> <pre>
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * </pre> </blockquote>
 */

public class AddDigits {
    // TC -> O(1), SC -> O(1)
    public int addDigits(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }

    // TC -> O(log(num)), SC -> O(1)
    public int addDigitsII(int num) {
        if (num == 0) return 0;
        while (num > 9) {
            num = num / 10 + num % 10;
        }
        return num;
    }

}
