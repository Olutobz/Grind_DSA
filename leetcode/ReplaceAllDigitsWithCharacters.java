/**
 * <blockquote> <pre>
 * Input: s = "a1c1e1"
 * Output: "abcdef"
 * Explanation: The digits are replaced as follows:
 *  s[1] -> shift('a',1) = 'b'
 *  s[3] -> shift('c',1) = 'd'
 *  s[5] -> shift('e',1) = 'f'
 *
 * Input: s = "a1b2c3d4e"
 * Output: "abbdcfdhe"
 * Explanation: The digits are replaced as follows:
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('b',2) = 'd'
 * - s[5] -> shift('c',3) = 'f'
 * - s[7] -> shift('d',4) = 'h'
 *  </pre> </blockquote>
 */

public class ReplaceAllDigitsWithCharacters {
    // TC -> O(N), SC -> O(N)
    private static String replaceDigits(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] result = s.toCharArray();
        for (int i = 1; i < result.length; i += 2) {
            int digit = result[i] - '0';
            result[i] = (char) (result[i - 1] + digit);
        }
        return new String(result);
    }
}
