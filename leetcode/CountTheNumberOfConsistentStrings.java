/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 08, October 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 * <p>
 * Return the number of consistent strings in the array words.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 *
 * Example 2:
 * Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * Output: 7
 * Explanation: All strings are consistent.
 *
 * Example 3:
 * Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * Output: 4
 * Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 *
 *
 * Constraints:
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * The characters in allowed are distinct.
 * words[i] and allowed contain only lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class CountTheNumberOfConsistentStrings {

    // TC -> O(N * M), SC -> O(N)
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> seen = new HashSet<>();
        int result = words.length;

        for (int i = 0; i < allowed.length(); i++) {
            seen.add(allowed.charAt(i));
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!seen.contains(ch)) {
                    result--;
                    break;
                }
            }
        }

        return result;
    }


    // TC -> O(N * M), SC -> O(1)
    public int countConsistentStringsII(String allowed, String[] words) {
        int result = words.length;
        boolean[] seen = new boolean[26];

        for (int i = 0; i < allowed.length(); i++) {
            seen[allowed.charAt(i) - 'a'] = true;
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!seen[ch - 'a']) {
                    result--;
                    break;
                }
            }
        }

        return result;
    }

}
