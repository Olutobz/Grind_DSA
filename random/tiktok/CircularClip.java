package tiktok;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 03, September 2024
 * EMAIL: damexxey94@gmail.com
 */

public class CircularClip {

    public static int contentStrength(String clip) {
        int n = clip.length();
        Set<String> uniqueSubstrings = new HashSet<>();
        String circularClip = clip + clip;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                char currCh = circularClip.charAt(i + j - 1);

                if (isVowel(currCh)) {
                    break;
                }
                sb.append(currCh);
                uniqueSubstrings.add(sb.toString());
            }
        }

        return uniqueSubstrings.size();
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

