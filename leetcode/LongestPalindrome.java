import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    // TC -> O(N), SC -> O(52)
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] charsFreq = new int[52];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                charsFreq[ch - 'a']++;
            } else {
                charsFreq[ch - 'A' + 26]++;
            }
        }

        for (int charNum : charsFreq) {
            count += charNum / 2;
        }

        count = count * 2;
        return Math.min(s.length(), count + 1);
    }

    // TC -> O(N), SC -> O(N)
    public int longestPalindromeII(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int res : map.values()) {
            count += res / 2;
        }
        count = count * 2;
        return Math.min(s.length(), count + 1);

    }

    // TC -> O(N), SC -> O(N)
    public int longestPalindromeIII(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }

        if (!set.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }
}
