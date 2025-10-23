package jpmc;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 23, October 2025
 * EMAIL: damexxey94@gmail.com
 */


import java.util.ArrayList;
import java.util.List;

/**
 * For each word in a list of words, if any two adjacent characters are equal, change one of them.
 * Determine the minimum number of substitutions so final string contains no adjacent equal characters.
 *
 * <blockquote>
 * <pre>
 * Example: words = ['add','boook','break']
 * 'add' : change one d (1 change)
 * 'boook' : change middle o (1 change)
 * 'break' : no changes necessary (0 changes)
 *
 * The return array is [1,1,0]
 * </blockquote>
 * </pre>
 */

public class NoPairsAllowed {

    // TC -> O(n), SC -> O(n)
    public List<Integer> removeAdjacentCharPairs(List<String> words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.isEmpty()) {
            return res;
        }

        for (String word : words) {
            int count = 0;
            char prev = word.charAt(0);
            for (int i = 1; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (prev == currChar) {
                    count++;
                    prev = '-';
                } else {
                    prev = currChar;
                }
            }
            res.add(count);
        }

        return res;
    }
}
