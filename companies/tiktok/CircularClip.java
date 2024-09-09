package tiktok;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 03, September 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given a string clip of length n consisting of only lowercase english chars,
 * imagine the clip is circular, meaning after n-th char,
 * the sequence continues from tne 1st char again.
 * <p>
 * Circular Nature: for instance, with string "yxz",
 * valid substrings are "y", "x", "z", "yx", "xz", "zy", "yxz", "xzy", and "zyx"
 * <p>
 * the "content strength" of a circular clip is determined
 * by the number of unique substrings that consists of only consonants.
 * Your task is to find the content strength of the circular clip.
 *
 * <blockquote>
 * <pre>
 * Example:
 * input: clip = "bac"
 * output : 3
 *
 * possible substrings are ["b", "a", "c", "ba", "ac", "cb", "bac", "acb", "cba"]
 * valid substrings are ["b", "c", "cb"]
 * </pre>
 * </blockquote>
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

