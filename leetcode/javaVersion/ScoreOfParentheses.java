package javaVersion; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 14, July 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.Stack;

/**
 * Given a balanced parentheses string s, return the score of the string.
 * <p>
 * The score of a balanced parentheses string is based on the following rule:
 * <p>
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "()"
 * Output: 1
 *
 * Example 2:
 * Input: s = "(())"
 * Output: 2
 *
 * Example 3:
 * Input: s = "()()"
 * Output: 2
 *
 * Example 4:
 * Input: s = "(()(()))"
 * Output: 4
 * </pre>
 * </blockquote>
 */

public class ScoreOfParentheses {

    // TC -> O(N), SC -> O(1)
    public int scoreOfParentheses(String s) {
        int depth = 0, score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                score += (int) Math.pow(2, depth);
            }
        }

        return score;
    }

    // TC -> O(N), SC -> O(N)
    public int scoreOfParenthesesII(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }

    // TC -> O(N), SC -> O(50) or O(1)
    public int scoreOfParenthesesIII(String s) {
        int[] res = new int[50];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res[++idx] = 0;
            } else {
                res[idx - 1] += Math.max(2 * res[idx], 1);
                idx--;
            }
        }

        return res[0];
    }

}
