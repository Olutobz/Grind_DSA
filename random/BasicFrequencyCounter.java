/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */
public class BasicFrequencyCounter {

    public static void main(String[] args) {
        String s = "abcdd";

        // Assuming only lowercase English letters, create an array to store frequencies
        int[] freq = new int[26];

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Display the frequencies
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('a' + i);
            if (freq[i] != 0) System.out.println(currentChar + ": " + freq[i]);
        }
    }
}