public class ReverseString {
    // TC -> O(N), SC -> O(1)
    public void reverseString(char[] s) {
        int first = 0, last = s.length - 1;
        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }
}
