public class ValidPalindrome {

    // TC -> O(N), SC -> O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(end);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                end--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                end--;
            }

        }

        return true;
    }

    // TC -> O(N), SC -> O(N)
    public boolean isPalindromeII(String s) {
        // remove all the characters that are not A-Z or a-z or 0-9.
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
