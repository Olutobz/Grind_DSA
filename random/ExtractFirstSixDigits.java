/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 31, May 2024
 * EMAIL: damexxey94@gmail.com
 */
public class ExtractFirstSixDigits {

    // TC -> O(1), SC -> O(1)
    private static String getFirstSixDigitsFromString(String numberString) {
        if (numberString.length() < 6) {
            throw new IllegalArgumentException("Please enter a string value of size 6");
        }
        return numberString.substring(0, 6);
    }

    // TC -> O(1), SC -> O(N)
    private static String getFirstSixDigitsFromStringII(String numberString) {
        if (numberString.length() < 6) {
            throw new IllegalArgumentException("Please enter a string value of size 6");
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char ch = numberString.charAt(i);
            if (Character.isDigit(ch)) {
                res.append(ch);
            } else break;
        }
        return res.toString();
    }
}
