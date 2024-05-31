/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 31, May 2024
 * EMAIL: damexxey94@gmail.com
 */
public class ExtractFirstSixDigits {

    // TC -> O(1), SC -> O(1)
    private String getFirstSixDigitsFromString(String numberString) {
        if (numberString.isEmpty()) return "";
        return numberString.substring(0, Math.min(6, numberString.length()));
    }

    // TC -> O(1), SC -> O(1) [assuming all the first 6 characters are all digits]
    private String getFirstSixDigitsFromStringII(String numberString) {
        if (numberString.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numberString.length() && i < 6; i++) {
            char ch = numberString.charAt(i);
            if (Character.isDigit(ch)) {
                res.append(ch);
            } else break;
        }
        return res.toString();
    }
}
