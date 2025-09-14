package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 02, November 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 *
 * Example 2:
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 *
 * Example 3:
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class MinimumDeletionsToMakeFrequenciesUnique {

    // TC -> O(n), SC -> O(n)
    public int minDeletions(String s) {
        if (s.isEmpty()) return 0;

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Set<Integer> seen = new HashSet<>();
        int deletion = 0;
        for (int count : freq) {
            while (count > 0 && seen.contains(count)) {
                count--;
                deletion++;
            }

            if (count > 0) {
                seen.add(count);
            }
        }

        return deletion;
    }

    // TC -> O(n), SC -> O(n)
    public int minDeletionsII(String s) {
        if (s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();
        int deletion = 0;
        for (int count : map.values()) {
            while (count > 0 && seen.contains(count)) {
                count--;
                deletion++;
            }

            if (count > 0) {
                seen.add(count);
            }
        }

        return deletion;
    }
}
