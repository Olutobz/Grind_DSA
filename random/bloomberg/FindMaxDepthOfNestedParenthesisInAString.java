package bloomberg;

import java.util.Stack;

/**
 * Input : S = "(a(b)(c)(d(e(f)g)h)I(j(k)l)m)";
 * Output : 4
 */

public class FindMaxDepthOfNestedParenthesisInAString {

    // TC -> O(N), SC -> O(N)
    private int maxDepth(String str) {
        if (str == null || str.isEmpty()) return 0;

        int count = 0;
        int max = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                count++;
                max = Math.max(count, max);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                count--;
            }
        }
        return max;
    }

    // TC -> O(N), SC -> O(N)
    private int maxDepthII(String str) {
        if (str == null || str.isEmpty()) return 0;

        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(i);
                max = Math.max(max, st.size());
            } else if (ch == ')' || ch == '}' || ch == ']') {
                st.pop();
            }
        }
        return max;
    }
}
