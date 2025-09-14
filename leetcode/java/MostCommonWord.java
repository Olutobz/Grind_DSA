package java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    private String computeString(String s) {
        s = s.replaceAll("\\W+", " ");
        s = s.trim().toLowerCase();
        return s;
    }

    // TC -> O(N), SC -> O(N)
    public String mostCommonWord(String paragraph, String[] banned) {
        String str = computeString(paragraph);
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String bannedWord : banned) {
            set.add(bannedWord);
        }

        for (String validWord : words) {
            if (!set.contains(validWord)) {
                map.put(validWord, map.getOrDefault(validWord, 0) + 1);
            }
        }

        int max = 0;
        String mostCommonWord = "";
        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                mostCommonWord = word;
            }
        }

        return mostCommonWord;
    }

    // TC -> O(N), SC -> O(N)
    public String mostCommonWordII(String paragraph, String[] banned) {
        String str = computeString(paragraph);
        String[] words = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : banned) {
            map.remove(word);
        }

        String res = null;
        for (String word : map.keySet())
            if (res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
}
