import java.util.Stack;

public class FindMaximumDepthOfNestedParenthesisInAString {

    /* Input : S = "(a(b)(c)(d(e(f)g)h)I(j(k)l)m)";
       Output : 4
    * */

    // TC -> O(N), SC -> O(N)
    public static int maxDepth(String s) {
        int count = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else if (s.charAt(i) == ')') {
                count = Math.max(count, st.size());
                st.pop();
            }
        }
        return count;
    }

    private int maxDepthII(String str) {
        int count = 0;
        int max = 0;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                count++;
                max = Math.max(count, max);
            } else if (c == ')' || c == '}' || c == ']') {
                count--;
            }

        }
        return max;
    }
}
