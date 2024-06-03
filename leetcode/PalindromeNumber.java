public class PalindromeNumber {

    // TC -> O(log x), SC -> O(1);
    private boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }

    // TC -> O(log x), SC -> O(1);
    private boolean isPalindromeII(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }

    // TC -> O(x), SC -> O(x);
    private boolean isPalindromeIII(int x) {
        if (x < 0) return false;
        String temp = Integer.toString(x);
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(++i) != temp.charAt(--j)) {
                return false;
            }
        }
        return true;
    }

}
