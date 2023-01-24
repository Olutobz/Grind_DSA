public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int i = 0, j = temp.length() - 1;

        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
