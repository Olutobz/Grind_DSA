import java.util.Stack;

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
}
