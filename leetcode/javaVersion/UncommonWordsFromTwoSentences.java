package javaVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    // TC -> O(N), SC -> O(N)
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : s1Words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : s2Words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String currWord : map.keySet()) {
            if (map.get(currWord) == 1) {
                result.add(currWord);
            }
        }

        return result.toArray(new String[0]);
    }
}
