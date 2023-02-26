public class PalindromicSubstrings {

    // TC -> O(N^2), SC -> O(1)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    // TC -> O(N), SC -> O(1)
    public int countPalindromes(String str, int l, int r) {
        int count = 0;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            count++;
            l--;
            r++;
        }

        return count;
    }
}
