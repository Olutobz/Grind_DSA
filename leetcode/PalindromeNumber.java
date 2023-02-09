public class PalindromeNumber {

    // TC -> O(N), SC -> O(N);
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String temp = Integer.toString(x);
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i++) != temp.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // TC -> O(LogN), SC -> O(1);
    public boolean isPalindromeII(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int res = 0;

        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return x == res || x == res / 10;
    }

}
