package google;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 30, July 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.*;

/**
 * Write a function that takes a 7-digits telephone number and prints out all the possible "words"
 * or combinations of letters that can represent the given numbers,
 * according to the letters associated with each key on the telephone keypad.
 * <p>
 * <blockquote>
 * <pre>
 * Examples:
 * "12" -> [a, b, c]
 * "88" -> [tt, tu, tv, ut, uu, uv, vt, vu, vv]
 * </pre>
 * </blockquote>
 */

public class TelephoneWords {

    private static final String[] KEYS =
            new String[]{" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static Map<Character, String> keyMap = new HashMap<>();

    static {
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
    }

    // TC -> O(N * 4^N), SC -> O(N * 4^N)
    private static List<String> findCombinations(String phoneNumber) {
        List<String> result = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() > 7) {
            return result;
        }

        backtrack(phoneNumber, 0, new StringBuilder(), result);
        return result;
    }

    // TC -> O(N * 4^N), SC -> O(N * 4^N)
    private static List<String> findCombinationsII(String phoneNumber) {
        List<String> res = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() > 7) {
            return res;
        }

        backtrackII(phoneNumber, 0, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(
            String phoneNumber, int index, StringBuilder currCombination, List<String> list
    ) {
        if (index == phoneNumber.length()) {
            list.add(currCombination.toString().trim());
            return;
        }

        String letters = KEYS[phoneNumber.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            currCombination.append(letters.charAt(i));
            backtrack(phoneNumber, index + 1, currCombination, list);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }

    private static void backtrackII(
            String phoneNumber, int index, StringBuilder currentCombination, List<String> res
    ) {
        if (index == phoneNumber.length()) {
            res.add(currentCombination.toString());
            return;
        }

        String letters = keyMap.get(phoneNumber.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            currentCombination.append(letters.charAt(i));
            backtrackII(phoneNumber, index + 1, currentCombination, res);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCombinations("12"));
        System.out.println(findCombinations("23"));
        System.out.println(findCombinationsII("23"));
        System.out.println(findCombinations("88"));
        System.out.println(findCombinationsII("88"));
    }

}
