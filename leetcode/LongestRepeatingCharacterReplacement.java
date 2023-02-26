import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    // TC -> O(N), SC -> O(26)
    public int characterReplacementII(String s, int k) {
        if (s == null || s.isEmpty()) return 0;

        int[] freq = new int[26];
        int left = 0, maxFreq = 0;
        int maxChars = 0;

        for (int right = 0; right < s.length(); right++) {
            char currCh = s.charAt(right);
            freq[currCh - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currCh - 'A']);
            int charsToReplace = (right - left + 1) - maxFreq;
            if (charsToReplace > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxChars = Math.max(maxChars, right - left + 1);

        }

        return maxChars;
    }

    // TC -> O(N), SC -> O(N)
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char currCh = s.charAt(right);
            map.put(currCh, map.getOrDefault(currCh, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(currCh));
            int lettersToChange = (right - left + 1) - maxFreq;

            if (lettersToChange > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }


}