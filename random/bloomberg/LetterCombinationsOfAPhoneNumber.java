package bloomberg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        LinkedList<String> result = new LinkedList<>();
        final String[] phoneKeys =
                new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        while (result.peek().length() != digits.length()) {
            String temp = result.remove();
            String map = phoneKeys[digits.charAt(temp.length()) - '0'];
            for (char c : map.toCharArray()) {
                result.addLast(temp + c);
            }
        }

        return result;
    }

}
