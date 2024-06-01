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
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = (rev * 10) + pop;
            x /= 10;
        }
        return rev;
    }

    // TC -> O(N), SC -> O(N)
    private int reverse2(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
