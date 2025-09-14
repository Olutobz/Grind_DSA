package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 06, September 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * You are given a string s consisting of lowercase English letters, and an integer k.
 * <p>
 * First, convert s into an integer by replacing each letter with its position in the alphabet
 * (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by
 * replacing it with the sum of its digits. Repeat the transform operation k times in total.
 * <p>
 * For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
 * <p>
 * Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * Transform #2: 17 ➝ 1 + 7 ➝ 8
 * Return the resulting integer after performing the operations described above.
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: s = "iiii", k = 1
 * Output: 36
 * Explanation: The operations are as follows:
 * Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
 * Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
 * Thus the resulting integer is 36.
 *
 * Example 2:
 * Input: s = "leetcode", k = 2
 * Output: 6
 * Explanation: The operations are as follows:
 * Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
 * Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
 * Transform #2: 33 ➝ 3 + 3 ➝ 6
 * Thus the resulting integer is 6.
 *
 * Example 3:
 * Input: s = "zbax", k = 2
 * Output: 8
 * </pre>
 * </blockquote>
 */

public class SumOfDigitsOfStringAfterConvert {

    // TC -> O(k * n), SC -> O(1)
    private int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'a' + 1;
            sum += digit / 10 + digit % 10;
        }

        while (k > 1) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            sum = newSum;
            k--;
        }

        return sum;
    }

    // TC -> O(k * n), SC -> O(n)
    private int getLuckyII(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'a' + 1;
            builder.append(digit);
        }

        String res = builder.toString();
        int sum = 0;
        while (k > 0) {
            sum = 0;
            for (int j = 0; j < res.length(); j++) {
                sum += res.charAt(j) - '0';
            }
            res = String.valueOf(sum);
            k--;
        }

        return sum;
    }

}
