import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    // TC -> O(N), SC -> O(N)
    public static String twoStrings(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return "No";
        }
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : s1.toCharArray()) {
            map.put(ch, 1);
        }

        for (Character ch : s2.toCharArray()) {
            if (map.containsKey(ch)) {
                return "YES";
            }
        }

        return "NO";
    }
}
