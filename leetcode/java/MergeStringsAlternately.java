package java; /**
 * Created by Onikoyi Damola Olutoba
 * DATE: 25 May 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * <blockquote> <pre>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * </pre></blockquote>
 */
public class MergeStringsAlternately {

    // TC -> O(M + N), SC -> O(N + M)
    private String mergeAlternately(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length(); ++i) {
            if (i < word1.length()) {
                builder.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                builder.append(word2.charAt(i));
            }
        }
        return builder.toString();
    }

    // TC -> O(M + N), SC -> O(N + M)
    private String mergeAlternatelyII(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int i, j;
        for (i = 0, j = 0; i < word1.length() && j < word2.length(); ++i, ++j) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(j));
        }
        if (i < word1.length()) {
            builder.append(word1.substring(i));
        }
        if (j < word2.length()) {
            builder.append(word2.substring(j));
        }
        return builder.toString();
    }

}
