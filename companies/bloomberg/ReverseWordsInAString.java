package bloomberg;

import java.util.Stack;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */

public class ReverseWordsInAString {

    // TC -> O(N), SC -> O(N)
    public String reverseWords(String s) {
        if (s.isEmpty()) return "";

        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                temp.append(ch);
            }

            if ((ch == ' ' || i == 0) && temp.length() > 0) {
                if (res.length() > 0) res.append(' ');
                temp.reverse();
                res.append(temp);
                temp.setLength(0);
            }

        }
        return res.toString();
    }

    // TC -> O(N), SC -> O(N)
    public static String reverseWordsII(String s) {
        if (s.isEmpty()) return "";

        Stack<String> stack = new Stack<>();
        String[] strArray = s.trim().split("\\s+");
        StringBuilder reverse = new StringBuilder();

        for (String str : strArray) {
            stack.push(str.trim());
        }

        while (!stack.isEmpty()) {
            String currStr = stack.pop();
            reverse.append(currStr);
            if (!stack.isEmpty()) {
                reverse.append(" ");
            }
        }
        return reverse.toString();
    }
}
