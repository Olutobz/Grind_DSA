import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    // TC -> O(N), SC -> O(N)
    public static int makingAnagrams(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return s2.length();
        if (s2 == null || s2.length() == 0) return s1.length();

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

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
                res++;
            }
        }

        for (int count : map.values()) {
            res += count;
        }

        return res;
    }
}
