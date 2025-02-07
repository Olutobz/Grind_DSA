package javaVersion; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 19, July 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Convert a non-negative integer num to its English words representation.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Constraints:
 * 0 <= num <= 2^31 - 1
 * </pre>
 * </blockquote>
 */

public class IntegerToEnglishWords {

    private final String[] belowTen =
            new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private final String[] belowTwenty =
            new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] belowHundred =
            new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    // TC -> O(log N), SC -> O(log N)
    private String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder res = new StringBuilder();
        if (num < 10) {
            res.append(belowTen[num]);
        } else if (num < 20) {
            res.append(belowTwenty[num - 10]);
        } else if (num < 100) {
            res.append(belowHundred[num / 10]).append(" ").append(helper(num % 10));
        } else if (num < 1000) {
            res.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            res.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            res.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            res.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }

        return res.toString().trim();
    }

}
