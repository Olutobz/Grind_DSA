import java.util.HashMap;
import java.util.Map;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */
public class BasicFrequencyCounter {

    public static void main(String[] args) {
        int[] freq = new int[26];
        String s = "aabbcddefff";

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }

        for (int i = 0; i < freq.length; i++) {
            char currentChar = (char) (i + 'a');
            if (freq[i] != 0) {
                System.out.println(currentChar + " -> count = " + freq[i] + "  ");
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.print("\nMap Values: ");
        for (int value : map.values()) {
            System.out.print(value + " ");
        }

        System.out.print("\nMap Keys: ");
        for (char ch : map.keySet()) {
            System.out.print(ch + " ");
        }

        System.out.println("\nMap Entries: ");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}