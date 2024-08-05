/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 04, August 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 *
 * Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 * </pre>
 * </blockquote>
 */
public class NumberOfMatchingSubsequences {

    // TC -> O(N + (M * K)), SC -> O(N)
    public int numMatchingSubseq(String s, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String wordStr : words) {
            map.put(wordStr, map.getOrDefault(wordStr, 0) + 1);
        }

        for (String currWord : map.keySet()) {
            int i = 0;
            int j = 0;

            while (i < currWord.length() && j < s.length()) {
                if (currWord.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }

            if (i == currWord.length()) {
                count += map.get(currWord);
            }
        }

        return count;
    }

}
