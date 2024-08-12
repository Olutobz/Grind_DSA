import java.util.HashMap;
import java.util.Map;


/**
 * We consider two strings to be anagrams of each other
 * if the first string's letters can be rearranged to form the second string.
 * In other words, both strings must contain the same exact letters in the same exact frequency.
 * For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * <p>
 * Alice is taking a cryptography class and finding anagrams to be very useful.
 * She decides on an encryption scheme involving two large strings where encryption
 * is dependent on the minimum number of character deletions required to make the two strings anagrams.
 * Can you help her find this number?
 * <p>
 * <p>
 * Given two strings, s1 and s2, that may not be of the same length,
 * determine the minimum number of character deletions required to make  and  anagrams.
 * Any characters can be deleted from either of the strings.
 *
 * <blockquote>
 * <pre>
 * Example :
 * s1 = abc
 * s2 = amnop
 * The only characters that match are the a's,
 * so we have to remove bc from s1 and mnop from s2 for a total of 6 deletions.
 * </pre>
 * </blockquote>
 */

public class MakingAnagrams {

    // TC -> O(N), SC -> O(N)
    public static int makingAnagrams(String s1, String s2) {
        if (s1 == null || s1.isEmpty()) return s2.length();
        if (s2 == null || s2.isEmpty()) return s1.length();

        Map<Character, Integer> map = new HashMap<>();
        int deletions = 0;

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int j = 0; j < s2.length(); j++) {
            if (map.containsKey(s2.charAt(j))) {
                if (map.get(s2.charAt(j)) == 1) {
                    map.remove(s2.charAt(j));
                } else {
                    map.put(s2.charAt(j), map.getOrDefault(s2.charAt(j), 0) - 1);
                }
            } else {
                deletions++;
            }
        }

        for (int count : map.values()) {
            deletions += count;
        }

        return deletions;
    }
}
