/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 06, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given a rows x cols screen and a sentence represented as a list of strings, return the number of times
 * the given sentence can be fitted on the screen.
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two lines.
 * A single space must separate two consecutive words in a line.
 *
 * <blockquote>
 * <pre>
 * Input : sentence = ["hello","world"], rows = 2, cols = 8
 * Output : 1
 * Explanation:
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * </pre>
 * </blockquote>
 */

public class SentenceScreenFitting {

    // TC -> O(row * maxLenOfWord), SC -> O(1)
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sentence) {
            sb.append(word).append(" ");
        }

        String sentenceStr = sb.toString();
        int sentenceLen = sentenceStr.length();
        int cursor = 0; // Tracks the position in the repeated sentence string

        for (int row = 0; row < rows; row++) {
            // Move the starting position forward by the number of columns in each row
            cursor += cols;

            // If the current position is a space, move one step further to the next word
            if (sentenceStr.charAt(cursor % sentenceLen) == ' ') {
                cursor++;
            } else {
                // Otherwise, backtrack to the cursor of the current word
                while (cursor >= 0 && sentenceStr.charAt(cursor % sentenceLen) != ' ') {
                    cursor--;
                }
            }
        }

        // Return the number of times the entire sentence fits in the screen
        return cursor / sentenceLen;
    }

}
