import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 * </pre>
 * </blockquote>
 */

public class LongestCommonPrefix {

    // TC -> O(n * m), SC -> O(1)
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return "";

        String prefix = str[0];
        for (int index = 1; index < str.length; index++) {
            while (str[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    // TC -> O(N * MLogM), SC -> O(1)
    public String longestCommonPrefixII(String[] str) {
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

}
