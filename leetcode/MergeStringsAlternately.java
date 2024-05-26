/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 25 May 2024
 * EMAIL: damexxey94@gmail.com
 */
public class MergeStringsAlternately {

    // TC -> O(N), SC -> O(N)
    private String mergeAlternately(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }

    // TC -> O(N), SC -> O(N)
    private String mergeAlternatelyII(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i, j;
        for (i = 0, j = 0; i < word1.length() && j < word2.length(); i++, j++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(j));
        }
        if (i < word1.length()) {
            result.append(word1.substring(i));
        }
        if (j < word2.length()) {
            result.append(word2.substring(j));
        }
        return result.toString();
    }

}
