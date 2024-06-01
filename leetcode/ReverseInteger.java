/*
* Input: x = 123
  Output: 321
*/
public class ReverseInteger {
    // TC -> O(log(x)), SC -> O(1)
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            int temp = result * 10 + pop;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = temp;
        }
        return result;
    }
}
