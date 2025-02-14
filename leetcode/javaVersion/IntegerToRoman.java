package javaVersion; /**
 * Created by Onikoyi Damola Olutoba
 * DATE: 18, July 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Seven different symbols represent Roman numerals with the following values:
 * <blockquote>
 * <pre>
 * Symbol	Value
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 *  </pre>
 * </blockquote>
 * <p>
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
 * Converting a decimal place value into a Roman numeral has the following rules:
 * <p>
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
 * append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
 * for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
 * Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
 * You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
 * If you need to append a symbol 4 times use the subtractive form.
 * <p>
 * Given an integer, convert it to a Roman numeral.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: num = 3749
 * Output: "MMMDCCXLIX"
 * Explanation:
 * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
 *   40 = XL as 10 (X) less of 50 (L)
 *    9 = IX as 1 (I) less of 10 (X)
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
 *
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 * Explanation:
 * 50 = L
 *  8 = VIII
 *
 * Example 3:
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation:
 * 1000 = M
 *  900 = CM
 *   90 = XC
 *    4 = IV
 *
 * </pre>
 * </blockquote>
 */
public class IntegerToRoman {

    // TC -> O(13) or O(1), SC -> O(13) or O(1)
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    // TC -> O(13) or O(1), SC -> O(13) or O(1)
    public String intToRomanII(int num) {
        if (num < 1 || num > 3999) return "";

        int[] keys = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (num > 0) {
            while (num >= keys[idx]) {
                res.append(values[idx]);
                num -= keys[idx];
            }
            idx++;
        }

        return res.toString();
    }

    // TC -> O(13) or O(1), SC -> O(13) or O(1)
    public String intToRomanIII(int num) {
        if (num < 1 || num > 3999) return "";

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                res.append(entry.getValue());
                num -= entry.getKey();
            }
        }

        return res.toString();
    }


    // TC -> O(13) or O(1), SC -> O(13) or O(1)
    public String intToRomanIv(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                sb.append("X");
                num -= 10;
            } else if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num -= 1;
            }
        }

        return sb.toString();
    }

}
