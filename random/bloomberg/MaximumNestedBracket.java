package bloomberg;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 08, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class MaximumNestedBracket {

    // TC -> O(N), SC -> O(N)
    private static int countMaxNestedBracket(String str) {
        int count = 0;
        int max = 0;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                count++;
                max = Math.max(count, max);
            } else if (c == ')' || c == '}' || c == ']') {
                count--;
            }
        }
        return max;
    }
}
