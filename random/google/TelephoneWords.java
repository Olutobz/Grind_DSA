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

    private static final String[] KEYPADS =
            new String[]{" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // TC -> O(N * 3^N), SC -> O(N * 3^N)
    private static List<String> findCombinations(String phoneNumber) {
        List<String> result = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() > 7) {
            return result;
        }
        findCombinationsHelper(phoneNumber, 0, new StringBuilder(), result);
        return result;
    }

    private static void findCombinationsHelper(
            String phoneNumber, int index, StringBuilder currCombination, List<String> res
    ) {
        if (index == phoneNumber.length()) {
            res.add(currCombination.toString().trim());
            return;
        }

        int digit = phoneNumber.charAt(index) - '0';
        String letters = KEYPADS[digit];

        for (char letter : letters.toCharArray()) {
            currCombination.append(letter);
            findCombinationsHelper(phoneNumber, index + 1, currCombination, res);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }

    // TC -> O(N * 3^N), SC -> O(N * 3^N)
    private static List<String> findCombinationsII(String phoneNumber) {
        List<String> res = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return res;
        }

        findCombinationsHelperII(phoneNumber, 0, new StringBuilder(), res);
        return res;
    }

    private static void findCombinationsHelperII(String phoneNumber, int index, StringBuilder currentCombination, List<String> res) {
        if (index == phoneNumber.length()) {
            res.add(currentCombination.toString());
            return;
        }

        Map<Character, String> keyPadMap = new HashMap<>();
        keyPadMap.put('1', "");
        keyPadMap.put('2', "abc");
        keyPadMap.put('3', "def");
        keyPadMap.put('4', "ghi");
        keyPadMap.put('5', "jkl");
        keyPadMap.put('6', "mno");
        keyPadMap.put('7', "pqrs");
        keyPadMap.put('8', "tuv");
        keyPadMap.put('9', "wxyz");

        char digit = phoneNumber.charAt(index);
        String letters = keyPadMap.get(digit);

        if (letters != null) {
            for (char letter : letters.toCharArray()) {
                currentCombination.append(letter);
                findCombinationsHelper(phoneNumber, index + 1, currentCombination, res);
                currentCombination.deleteCharAt(currentCombination.length() - 1);
            }
        } else {
            findCombinationsHelper(phoneNumber, index + 1, currentCombination, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCombinations("12"));
        System.out.println(findCombinations("03"));
        System.out.println(findCombinations("82"));
        System.out.println(findCombinationsII("82"));
    }


}
