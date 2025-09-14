package java;

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
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    // TC -> O(n * m), SC -> O(1)
    public String longestCommonPrefixII(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || strs[0].charAt(i) != s.charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }

        return strs[0];
    }

    // TC -> O(N * MLogM), SC -> O(1)
    public String longestCommonPrefixIII(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(i)) i++;
            else break;
        }

        return i == 0 ? "" : first.substring(0, i);
    }

}
