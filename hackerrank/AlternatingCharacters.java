import java.util.HashMap;

public class AlternatingCharacters {

    public static int alternatingCharacters(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        int sumTotal = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count.put(str.charAt(i - 1),
                        count.containsKey(str.charAt(i - 1)) ? count.get(str.charAt(i - 1)) + 1 : 1);
            }
        }

        for (int num : count.values()) {
            sumTotal += num;
        }
        return sumTotal;
    }

}
