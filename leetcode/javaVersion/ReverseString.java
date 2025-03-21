package javaVersion;

import java.util.Arrays;
import java.util.Stack;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * </pre>
 * </blockquote>
 */

public class ReverseString {

    // TC -> O(N), SC -> O(1)
    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int first = 0, last = s.length - 1;
        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }

    // TC -> O(N), SC -> O(N)
    private static void reverseStringII(char[] s) {
        if (s == null || s.length == 0) return;
        int first = 0, last = s.length - 1;
        swapRecursively(s, first, last);
        System.out.println(Arrays.toString(s));
    }

    private static void swapRecursively(char[] s, int first, int last) {
        if (first >= last) return;
        char temp = s[first];
        s[first] = s[last];
        s[last] = temp;
        swapRecursively(s, ++first, --last);
    }

    // TC -> O(N), SC -> O(N)
    private static void reverseStringIII(char[] s) {
        if (s == null || s.length == 0) return;
        Stack<Character> stack = new Stack<>();

        for (char ch : s) {
            stack.push(ch);
        }

        int index = 0;
        while (!stack.isEmpty()) {
            s[index++] = stack.pop();
        }

        System.out.println(Arrays.toString(s));
    }

}
