import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInAString {

    // TC -> O(N), SC -> O(26);
    public char findFirstUniqueChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[(s.charAt(i) - 'a')] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // TC -> O(N), SC -> O(N);
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';

    }


}
