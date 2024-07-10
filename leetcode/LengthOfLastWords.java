public class LengthOfLastWords {

    // TC -> O(1), SC -> O(N)
    public int lengthOfLastWordIII(String s) {
        if (s == null || s.isEmpty()) return -1;
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }

    // TC -> O(N), SC -> O(1)
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return -1;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0) return count;
            }
        }
        return count;
    }

    // TC -> O(N), SC -> O(1)
    public int lengthOfLastWordII(String s) {
        if (s == null || s.isEmpty()) return -1;
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
