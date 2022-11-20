public class FindTheIndexOfTheFirstOccurrenceInAString {
    // TC -> O(M*N), SC -> O(1)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty() || haystack.length() < needle.length()) return -1;

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) return i - j;
                else j++;
            } else if (j > 0) {
                i = i - j;
                j = 0;
            }
        }

        return -1;

    }

    // TC -> O(M*N), SC -> O(1)
    public int strStrII(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                if (i == m - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }
}
