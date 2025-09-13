package java;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid;
 * there are no extra white spaces, square brackets are well-formed, etc. Furthermore,
 * you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * </pre>
 * </blockquote>
 */
public class DecodeString {

    // TC -> O(N), SC -> O(N)
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';

            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(res);
                res = new StringBuilder();
                k = 0;

            } else if (ch == ']') {
                StringBuilder temp = res;
                res = strStack.pop();
                for (k = intStack.pop(); k > 0; k--) {
                    res.append(temp);
                }
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

}
