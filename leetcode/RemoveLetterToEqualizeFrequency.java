/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, May 2025
 * EMAIL: damexxey94@gmail.com
 */


/**
 * You are given a 0-indexed string word, consisting of lowercase English letters.
 * You need to select one index and remove the letter at that index from word
 * so that the frequency of every letter present in word is equal.
 * <p>
 * Return true if it is possible to remove one letter so that the frequency
 * of all letters in word are equal, and false otherwise.
 * <p>
 * Note:
 * The frequency of a letter x is the number of times it occurs in the string.
 * You must remove exactly one letter and cannot choose to do nothing.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: word = "abcc"
 * Output: true
 * Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
 *
 * Example 2:
 * Input: word = "aazz"
 * Output: false
 * Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
 *
 * Constraints:
 * 2 <= word.length <= 100
 * word consists of lowercase English letters only.
 * </pre>
 * </blockquote>
 */

public class RemoveLetterToEqualizeFrequency {

    // TC -> O(N), SC -> O(1)
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            freq[i]--;
            if (isEqual(freq)) {
                return true;
            }
            freq[i]++;
        }

        return false;
    }

    private boolean isEqual(int[] data) {
        int lastCount = 0;
        for (int count : data) {
            if (count == 0) {
                continue;
            }
            if (lastCount != 0 && count != lastCount) {
                return false;
            }
            lastCount = count;
        }
        return true;
    }
}
