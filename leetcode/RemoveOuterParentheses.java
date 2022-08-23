
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
}
