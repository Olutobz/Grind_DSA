package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 12, August 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * </pre>
 * </blockquote>
 */

public class BackspaceStringCompare {

    // TC -> O(N + M), SC -> O(1)
    private static boolean backspaceCompare(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }

        return removeBackspacesFromString(s).equals(removeBackspacesFromString(t));
    }

    private static String removeBackspacesFromString(String str) {
        StringBuilder builder = new StringBuilder();
        int skip = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }

    // TC -> O(N + M), SC -> O(N + M)
    public static boolean backspaceCompareII(String s, String t) {
        return removeBackspacesFromStringII(s).equals(removeBackspacesFromStringII(t));
    }

    public static String removeBackspacesFromStringII(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') stack.push(c);
            else if (!stack.empty()) stack.pop();
        }
        return String.valueOf(stack);
    }


    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompareII("yf#c#", "yy#k#pp##"));
        System.out.println(backspaceCompare("a##c", "#a#cf"));
    }

}
