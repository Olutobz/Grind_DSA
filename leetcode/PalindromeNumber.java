public class PalindromeNumber {

    // TC -> O(N), SC -> O(1);
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
}
