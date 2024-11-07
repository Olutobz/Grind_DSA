package slidingwindow;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * You are given a binary string s (a string containing only "0" and "1").
 * You may choose up to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?
 *
 * <blockquote>
 * <pre>
 * For example, given s = "1101100111", the answer is 5.
 * If you perform the flip at index 2, the string becomes 1111100111.
 * </pre>
 * </blockquote>
 */

public class LengthOfLongestSubstring {

    // TC -> O(N), SC -> O(1)
    private static int findLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int count = 0;

        for (int right = 0, left = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                count++;
            }
            while (count > 1) {
                if (s.charAt(left) == '0') {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

}
