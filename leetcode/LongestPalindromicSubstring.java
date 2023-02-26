public class LongestPalindromicSubstring {
    // TC -> O(N^2), SC -> O(1)
    public String longestPalindrome(String s) {
        String res = "";
        int currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLen - 1, i)) {
                res = s.substring(i - currLen - 1, i + 1);
                currLen += 2;

            } else if (isPalindrome(s, i - currLen, i)) {
                res = s.substring(i - currLen, i + 1);
                currLen++;
            }
        }

        return res;

    }

    // TC -> O(N), SC -> O(1)
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
