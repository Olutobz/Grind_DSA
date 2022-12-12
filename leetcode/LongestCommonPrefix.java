import java.util.Arrays;

public class LongestCommonPrefix {

    // TC -> O(NLogN), SC -> O(max(M,N))
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    // TC -> O(NM), SC -> O(1)
    public String longestCommonPrefixII(String[] strs) {
        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
