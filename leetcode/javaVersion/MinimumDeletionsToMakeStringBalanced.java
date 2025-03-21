package javaVersion; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 30, July 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.Stack;

/**
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.
 * <p>
 * You can delete any number of characters in s to make s balanced.
 * s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 * <p>
 * Return the minimum number of deletions needed to make s balanced.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 *
 * Example 2:
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 * </pre>
 * </blockquote>
 */

public class MinimumDeletionsToMakeStringBalanced {

    // TC -> O(N), SC -> O(1)
    private int minimumDeletions(String s) {
        if (s.isEmpty()) return 0;

        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                count++;
            } else if (count != 0) {
                count--;
                res++;
            }
        }

        return res;
    }

    // TC -> O(N), SC -> O(N)
    private int minimumDeletionsII(String s) {
        if (s.isEmpty()) return 0;

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a') {
                count++;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return count;
    }

}
