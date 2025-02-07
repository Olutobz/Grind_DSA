package javaVersion; /**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */


import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 *  Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * </pre>
 * </blockquote>
 */

public class LetterCombinationsOfAPhoneNumber {

    // TC -> O(N * 4^N), SC -> O(N * 4^N)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty() || digits.length() > 4) {
            return res;
        }

        backtrack(digits, 0, res, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, List<String> list, StringBuilder currCombination) {
        if (index == digits.length()) {
            list.add(currCombination.toString());
            return;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            currCombination.append(letters.charAt(i));
            backtrack(digits, index + 1, list, currCombination);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }

    // TC -> O(N * 4^N), SC -> O(4^N)
    private List<String> letterCombinationsII(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.isEmpty() || digits.length() > 4) {
            return res;
        }

        final String[] KEYS = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add(0, "");

        for (int i = 0; i < digits.length(); i++) {
            String letters = KEYS[digits.charAt(i) - '0'];
            int listSize = res.size();
            for (int j = 0; j < listSize; j++) {
                String temp = res.remove(0);
                for (char ch : letters.toCharArray()) {
                    res.add(temp + ch);
                }
            }
        }

        return res;
    }

}
