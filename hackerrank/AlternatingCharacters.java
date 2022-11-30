import java.util.HashMap;

public class AlternatingCharacters {

    // TC -> O(N), SC -> O(N)
    public static int alternatingCharacters(String str) {
        if (str == null || str.isEmpty()) return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        int sumTotal = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                map.put(str.charAt(i - 1),
                        map.containsKey(str.charAt(i - 1)) ? map.get(str.charAt(i - 1)) + 1 : 1);
            }
        }

        for (int num : map.values()) {
            sumTotal += num;
        }
        return sumTotal;
    }

    // TC -> O(N), SC -> O(N)
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
