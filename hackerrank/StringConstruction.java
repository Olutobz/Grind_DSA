import java.util.HashMap;
import java.util.Map;

public class StringConstruction {

    // TC -> O(N), SC -> O(N)
    public static int stringConstruction(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map.size();
    }
}
