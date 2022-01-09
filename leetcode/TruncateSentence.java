public class TruncateSentence {

    // TC -> O(N), SC -> O(1)
    public String truncateSentence(String s, int k) {
        if (s == null || s.length() == 0) return "";
        String[] words = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++) {
            str.append(words[i]).append(' ');
        }

        return str.toString().trim();

    }
}
