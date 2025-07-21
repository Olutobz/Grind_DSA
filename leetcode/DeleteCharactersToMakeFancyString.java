/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, July 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * A fancy string is a string where no three consecutive characters are equal.
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "leeetcode"
 * Output: "leetcode"
 * Explanation:
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 *
 * Example 2:
 * Input: s = "aaabaaaa"
 * Output: "aabaa"
 * Explanation:
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 *
 * Example 3:
 * Input: s = "aab"
 * Output: "aab"
 * Explanation: No three consecutive characters are equal, so return "aab".
 *
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class DeleteCharactersToMakeFancyString {

    // TC -> O(n), SC -> O(1)
    public String makeFancyString(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        char prev = s.charAt(0);
        int freq = 1;
        res.append(prev);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                freq++;
            } else {
                freq = 1;
                prev = s.charAt(i);
            }
            if (freq < 3) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

}
