/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 06, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * A word is considered valid if:
 * It contains a minimum of 3 characters.
 * It contains only digits (0-9), and English letters (uppercase and lowercase).
 * It includes at least one vowel.
 * It includes at least one consonant.
 * You are given a string word.
 * Return true if word is valid, otherwise, return false.
 * Notes:
 * 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
 * A consonant is an English letter that is not a vowel.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: word = "234Adas"
 * Output: true
 * Explanation:
 * This word satisfies the conditions.
 *
 * Example 2:
 * Input: word = "b3"
 * Output: false
 * Explanation:
 * The length of this word is fewer than 3, and does not have a vowel.
 *
 * Example 3:
 * Input: word = "a3$e"
 * Output: false
 * Explanation:
 * This word contains a '$' character and does not have a consonant.
 *
 * Constraints:
 * 1 <= word.length <= 20
 * word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.
 * </pre>
 * </blockquote>
 */

public class ValidWord {

    // TC -> O(N), SC -> O(1)
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) {
            return false;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                consonants++;
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return vowels > 0 && consonants > 0;
    }
}
