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
                System.out.print(currentChar + " -> " + freq[i] + "  ");
            }
        }
    }

}