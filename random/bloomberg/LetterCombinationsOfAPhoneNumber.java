package bloomberg;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;

        final String[] KEYS = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = KEYS[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }

        return ans;
    }

}
