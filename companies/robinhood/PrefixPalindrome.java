package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 09, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Constraint: 0<=len(s)<=1000
 * Given a string:
 * 1. Take all prefixes of the string and choose the longest palindrome between them.
 * 2. If the chosen prefix has at least two characters,
 * cut this from s and go back to step 1 with the updated string. Otherwise,
 * end the algo with the current string s.
 */

public class PrefixPalindrome {

    public static String solvePrefixPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int max = 0;

        for (int i = 2; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            StringBuilder go = new StringBuilder(s1);
            String s2 = String.valueOf(go.reverse());
            if (s2.equals(s1)) {
                if (s2.length() > max) {
                    max = s2.length();
                }
            }
        }

        if (max > 1) {
            return solvePrefixPalindrome(s.substring(max));
        } else {
            return s.substring(max);
        }
    }


    public String solvePrefixPalindromeII(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String pre = getPrefixPalindrome(s);
        if (pre.length() > 1) {
            return solvePrefixPalindromeII(s.substring(pre.length()));
        } else
            return s;
    }

    private String getPrefixPalindrome(String str) {
        String temp = str + '?';
        str = reverse(str);
        temp += str;
        int n = temp.length();

        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            int len = arr[i - 1];
            while (len > 0 && temp.charAt(len) != temp.charAt(i)) {
                len = arr[len - 1];
            }
            if (temp.charAt(i) == temp.charAt(len)) {
                len++;
            }
            arr[i] = len;
        }
        return temp.substring(0, arr[n - 1]);
    }

    private String reverse(String str) {
        char[] a = str.toCharArray();
        int start, end = a.length - 1;

        for (start = 0; start < end; start++, end--) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }

        return new String(a);
    }
}
