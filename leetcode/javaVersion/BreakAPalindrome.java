package javaVersion;

public class BreakAPalindrome {

    // TC -> O(N), SC -> O(N)
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() < 2) {
            return "";
        }

        char[] arr = palindrome.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }

        arr[arr.length - 1] = 'b';
        return String.valueOf(arr);
    }
}
