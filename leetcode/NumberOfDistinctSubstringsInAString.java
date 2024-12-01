/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 09, November 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the number of distinct substrings of s.
 * <p>
 * A substring of a string is obtained by deleting any number of characters (possibly zero)
 * from the front of the string and any number (possibly zero) from the back of the string.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "aabbaba"
 * Output: 21
 * Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
 *
 * Example 2:
 * Input: s = "abcdefg"
 * Output: 28
 *
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * </pre>
 * </blockquote>
 **/

public class NumberOfDistinctSubstringsInAString {

    public static int countDistinct(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<String> ss = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j <= s.length(); ++j) {
                ss.add(s.substring(i, j));
            }
        }

        return ss.size();
    }

}
