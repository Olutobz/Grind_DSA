package javaVersion;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    private void palindromePermutation(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] strArray = s.toLowerCase().toCharArray();

        for (char ch : strArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        if (s.length() % 2 == 0) {
            for (Character character : map.keySet()) {
                if (map.get(character) % 2 != 0) {
                    System.out.println("False");
                    System.exit(0);
                }
            }
            System.out.println("True");
        } else {
            int oddCharCount = 0;
            for (Character character : map.keySet()) {
                if (map.get(character) % 2 != 0) {
                    oddCharCount++;
                }
            }
            if (oddCharCount > 1) {
                System.out.println("False");
                System.exit(0);
            } else {
                System.out.println("True");
                System.exit(0);
            }
        }
    }
}
