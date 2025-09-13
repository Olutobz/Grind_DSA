package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 16, July 2025
 * EMAIL: damexxey94@gmail.com
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: ["neet","code","love","you"]
 * Output:["neet","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 *
 * Example 2:
 * Input: ["we","say",":","yes"]
 * Output: ["we","say",":","yes"]
 *
 * Constraints:
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 * </pre>
 * </blockquote>
 */


public class EncodeAndDecodeStrings {

    // TC -> O(n), SC -> O(n + m)
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder res = new StringBuilder();
        for (String currStr : strs) {
            res.append(currStr.length()).append('#').append(currStr);
        }

        return res.toString();
    }

    // TC -> O(n), SC -> O(n + m)
    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int currStrLen = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = currStrLen + i;
            result.add(str.substring(i, j));
            i = j;
        }

        return result;
    }

}
