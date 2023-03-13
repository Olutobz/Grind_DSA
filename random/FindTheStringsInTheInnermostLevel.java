import java.util.ArrayList;
import java.util.List;

public class FindTheStringsInTheInnermostLevel {

    public static void main(String[] args) {
        String str = "abc(def)ghi[jkl]mno";
        System.out.println(getString(str));
    }

    public static List<String> getString(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;

        int count = 0;
        int max = countNestedBrackets(str);
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                count++;
                str = "";
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (count == max) {
                    res.add(str);
                }
                count--;
            } else {
                str += ch;
            }

        }

        return res;
    }

    // TC -> O(N), SC -> O(1)
    private static int countNestedBrackets(String str) {
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
