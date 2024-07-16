import java.util.Stack;

public class RemoveOuterParentheses {

    // TC -> O(N), SC -> O(N)
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (opened > 0) builder.append(c);
                opened++;
            } else {
                opened--;
                if (opened > 0) builder.append(c);
            }
        }

        return builder.toString();
    }

    // TC -> O(N), SC -> O(N)
    public String removeOuterParenthesesII(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) builder.append(ch);
                stack.push(ch);
            } else {
                stack.pop();
                if (!stack.isEmpty()) builder.append(ch);
            }
        }

        return builder.toString();
    }
}
