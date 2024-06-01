/*
 * Input: x = 123 => Output: 321
 * Input: x = -123 => Output: -321
 */
public class ReverseInteger {
    // TC -> O(log(x)), SC -> O(1)
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            int temp = rev * 10 + pop;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = temp;
        }
        return rev;
    }
}
