import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    // TC -> O(N), SC -> O(1);
    public int firstUniqCharIII(String s) {
        if (s == null || s.length() == 0) return -1;
        for (char c : s.toCharArray()) {
            int index = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (index == lastIndex)
                return index;
        }
        return -1;
    }

    // TC -> O(N), SC -> O(26);
    public int firstUniqCharII(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[(s.charAt(i) - 'a')] == 1) {
                return i;
            }
        }
        return -1;
    }

    // TC -> O(N), SC -> O(N);
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
