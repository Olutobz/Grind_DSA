import java.util.Arrays;

public class LongestCommonPrefix {

    // TC -> O(NLogN), SC -> O(1)
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return "";

        Arrays.sort(str);
        String first = str[0];
        String last = str[str.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c)) c++;
            else break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    // TC -> O(NM), SC -> O(1)
    public String longestCommonPrefixII(String[] str) {
        if (str == null || str.length == 0) return "";
        String prefix = str[0];
        for (int index = 1; index < str.length; index++) {
            while (str[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
