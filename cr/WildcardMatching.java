public class WildcardMatching {

    /* The basic idea is to have one pointer for the string and one pointer for the pattern.
       This algorithm iterates at most length(string) + length(pattern) times, for each iteration,
       at least one pointer advance one step.
     */

    // TC -> O(M * N), SC -> O(1) where, M = length(str) and N = length(pattern)
    public boolean isMatch(String str, String pattern) {
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
