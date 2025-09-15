package java;

public class WildcardMatching {

    /* The basic idea is to have one pointer for the string and one pointer for the pattern.
       This algorithm iterates at most length(string) + length(pattern) times, for each iteration,
       at least one pointer advance one step.
     */


    // TC -> O(M * N), SC -> O(N + M) where, M = length(str) and N = length(pattern)
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j < n + 1; j++) {
            if (pc[j - 1] == '*') dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (pc[j - 1] == sc[i - 1] || pc[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    // TC -> O(M * N), SC -> O(1) where, M = length(str) and N = length(pattern)
    public boolean isMatchII(String str, String pattern) {
        int i = 0, j = 0;
        int match = 0, starIdx = -1;

        while (i < str.length()) {
            // advancing both pointers
            if (j < pattern.length() && (pattern.charAt(j) == '?' || str.charAt(i) == pattern.charAt(j))) {
                i++;
                j++;
            }
            // * found, only advancing pattern pointer
            else if (j < pattern.length() && pattern.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                j = starIdx + 1;
                match++;
                i = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        // check for remaining characters in pattern
        while (j < pattern.length() && pattern.charAt(j) == '*') {
            j++;
        }


        return j == pattern.length();
    }
}
