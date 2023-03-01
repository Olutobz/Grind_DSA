import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';

            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(res);
                res = new StringBuilder();
                k = 0;

            } else if (ch == ']') {
                StringBuilder temp = res;
                res = strStack.pop();
                for (k = intStack.pop(); k > 0; k--) {
                    res.append(temp);
                }
            } else {
                res.append(ch);
            }
        }

        return res.toString();

    }
}
