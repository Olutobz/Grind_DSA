package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 03, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 *
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 *
 * Constraints:
 * 1 <= s.length, goal.length <= 100
 * s and goal consist of lowercase English letters.
 *     </pre>
 * </blockquote>
 */

public class RotateString {

    // TC -> O(n), SC -> O(n)
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        String doubleString = s + s;
        return doubleString.contains(goal);
    }

    // TC -> O(n^2), SC -> O(1)
    public boolean rotateStringII(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (rotateStringHelper(s, goal, i)) {
                return true;
            }
        }

        return false;
    }

    // TC -> O(n^2), SC -> O(n)
    public boolean rotateStringIII(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            rotateOnce(sChars);
            if (String.valueOf(sChars).equals(goal)) {
                return true;
            }
        }

        return false;
    }

    private boolean rotateStringHelper(String s, String goal, int rotation) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt((i + rotation) % goal.length())) {
                return false;
            }
        }
        return true;
    }

    private void rotateOnce(char[] arr) {
        char firstChar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = firstChar;
    }

}
