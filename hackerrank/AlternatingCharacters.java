import java.util.HashMap;

public class AlternatingCharacters {

    public static int alternatingCharacters(String str) {
        if (str == null || str.isEmpty()) return -1;

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

    public static int alternatingCharactersII(String str) {
        char[] sArray = str.toCharArray();
        char currentLetter = sArray[0];
        int count = 0;

        for (int i = 0; i < sArray.length; i++) {
            if (i == 0) {
                continue;
            }
            if (sArray[i] == currentLetter) {
                count++;
            } else {
                currentLetter = sArray[i];
            }
        }
        return count;
    }

}
