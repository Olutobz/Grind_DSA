import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    /* Intuition:
       1. count letter appearances and store in hash[] or map
       2. find the letter with most occurrence
       3. put the letter into even index numbers (0, 2, 4...) in a char array
       4. put the rest into the array
    */

    // TC -> O(N), SC -> O(N + 26)
    public String reorganizeString(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int max = 0, maxChar = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;
        while (freq[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx += 2;
            freq[maxChar]--;
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }

        return String.valueOf(res);
    }

    // TC -> O(N), SC -> O(N)
    public String reorganizeStringII(String s) {
        if (s == null || s.length() == 1) return s;

        Map<Character, Integer> map = new HashMap<>();
        char maxChar = s.charAt(0);
        int len = s.length();

        // count chars in map, get max
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > map.get(maxChar)) {
                maxChar = c;
            }
        }

        if (map.get(maxChar) > (len + 1) / 2) return "";

        int idx = 0;
        char[] res = new char[len];

        // put all maxChar's into array (may not reach end of s)
        while (idx < len && map.get(maxChar) > 0) {
            res[idx] = maxChar;
            map.put(maxChar, map.get(maxChar) - 1);
            idx += 2;
        }

        // loop through map, may go through a key where val is 0, but won't do anything
        for (Character c : map.keySet()) {
            while (map.get(c) > 0) {
                if (idx >= len)
                    idx = 1; // First time it reaches len, reset it.
                res[idx] = c;
                map.put(c, map.get(c) - 1);
                idx += 2;
            }
        }
        return new String(res);
    }
}
