import java.util.Arrays;

/**
 * A recently launched supplemental typing keypad gained significant popularity on Amazon Shopping due to its flexibility.
 * This keypad can be connected to any electronic device and has 9 buttons, where each button can have up to 3 lowercase English letters.
 * The buyer has the freedom to choose which letters to place on a button while ensuring that the arrangement is valid.
 * A keypad design is said to be valid if:
 * All 26 letters of the English alphabet exist on the keypad.
 * Each letter is mapped to exactly one button
 */

public class MinimumClickCount {

    public static int minClickCount(String s) {
        int count = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int index = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (index < 9) {
                count += freq[i];
            } else if (index < 18) {
                count += 2 * freq[i];
            } else {
                count += 3 * freq[i];
            }
            index++;
        }
        return count;
    }
}
