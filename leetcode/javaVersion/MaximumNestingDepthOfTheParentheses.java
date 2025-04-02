package javaVersion;

import java.util.Stack;

/**
 * Given a valid parentheses string s, return the nesting depth of s.
 * The nesting depth is the maximum number of nested parentheses.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation:
 * Digit 8 is inside of 3 nested parentheses in the string.
 *
 * Example 2:
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * Explanation:
 * Digit 3 is inside of 3 nested parentheses in the string.
 *
 * Example 3:
 * Input: s = "()(())((()()))"
 * Output: 3
 * </pre>
 * </blockquote>
 */

public class MaximumNestingDepthOfTheParentheses {

    // TC -> O(N), SC -> O(1)
    public int maxDepth(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // TC -> O(N), SC -> O(N)
    public int maxDepthII(String s) {
        if (s == null || s.isEmpty()) return 0;

        Stack<Character> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
            max = Math.max(max, stack.size());
        }
        return max;
    }
}
