public class TruncateSentence {

    // TC -> O(N), SC -> O(1)
    public String truncateSentenceIII(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int spaceCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
                if (spaceCount == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

    // TC -> O(N), SC -> O(1)
    public String truncateSentenceII(String s, int k) {
        if (s == null || s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') spaceCount++;
            if (spaceCount == k) break;
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    // TC -> O(N), SC -> O(N)
    public String truncateSentence(String s, int k) {
        if (s == null || s.length() == 0) return "";
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(words[i]).append(' ');
        }
        return res.toString().trim();
    }

}
