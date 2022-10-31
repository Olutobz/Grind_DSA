public class LengthOfLastWords {

    // TC -> O(1), SC -> O(1)
    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        s = strArr[strArr.length - 1];
        return s.length();
    }

    // TC -> O(N), SC -> O(1)
    public int lengthOfLastWordII(String s) {
        s = s.trim();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

}
