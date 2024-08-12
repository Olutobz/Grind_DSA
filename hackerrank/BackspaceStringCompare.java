/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 12, August 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given two strings containing lowercase English letters and the # character which represents a backspace key,
 * determine if the two final strings are equal. Return 1 if they are equal or 0 if they are not.
 * Note that backspacing an empty string results in an empty string
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * String s1 = "ab#c";
 * String s2 = "ad#c";
 * Output: 1
 *
 * Example 2:
 * String s3 = "a##c";
 * String s4 = "#a#c";
 * Output: 1
 *
 * Example 3:
 * String s7 = "yf#c#";
 * String s8 = "yy#k#pp##";
 * Output: 1
 * </pre>
 * </blockquote>
 */
public class BackspaceStringCompare {

    // TC -> O(N), SC -> O(1)
    private static int compareStrings(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        return removeBackspacesFromString(s1).equals(removeBackspacesFromString(s2)) ? 1 : 0;
    }

    private static String removeBackspacesFromString(String str) {
        StringBuilder builder = new StringBuilder();
        int skip = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("ab#c", "ad#c"));
        System.out.println(compareStrings("a##c", "#a#c"));
        System.out.println(compareStrings("yf#c#", "yy#k#pp##"));
        System.out.println(compareStrings("a##c", "#a#cf"));
    }

}
