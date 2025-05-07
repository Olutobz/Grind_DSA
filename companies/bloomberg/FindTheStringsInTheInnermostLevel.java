package bloomberg;

import java.util.ArrayList;
import java.util.List;

public class FindTheStringsInTheInnermostLevel {

    public static void main(String[] args) {
        String str = "abc(d(e)f)ghi[jkl]mno";
        System.out.println(getInnerMostString(str));
    }

    // TC -> O(N), SC -> O(N)
    public static List<String> getInnerMostString(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int max = 0;
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                count++;
                max = Math.max(max, count);
                temp.setLength(0);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (count == max) {
                    res.add(temp.toString());
                }
                count--;
            } else {
                temp.append(ch);
            }
        }
        return res;
    }

}
