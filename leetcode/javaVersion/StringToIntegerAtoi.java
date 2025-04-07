package javaVersion;

public class StringToIntegerAtoi {
    // TC -> O(N), SC -> O(1)
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        // ignore whitespace
        s = s.trim();
        if (s.length() == 0) return 0;
        int sign = 1;
        long res = 0;
        if (s.charAt(0) == '-') sign = -1;

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        // initiate starting pointer
        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) {
                break;
            }
            res = res * 10 + s.charAt(i) - '0';
            // check for range of integer
            if (sign == -1 && -1 * res < MIN) return MIN;
            if (sign == 1 && res > MAX) return MAX;
            i++;
        }

        return (int) (sign * res);

    }
}
