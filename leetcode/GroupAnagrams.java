import java.util.*;

public class GroupAnagrams {

    // TC -> O(N*MLogM), SC -> O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String currStr = Arrays.toString(ch);
            if (!map.containsKey(currStr)) {
                map.put(currStr, new ArrayList<>());
            }
            map.get(currStr).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // TC -> O(N*M), SC -> O(N)
    public List<List<String>> groupAnagramsII(String[] str) {
        if (str == null || str.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : str) {
            char[] freq = new char[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            String currStr = Arrays.toString(freq);
            if (!map.containsKey(currStr)) {
                map.put(currStr, new ArrayList<>());
            }
            map.get(currStr).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
