public class RearrangeCharactersToMakeTargetString {

    // TC -> O(N), SC -> O(N)
    public int rearrangeCharacters(String s, String target) {
        int[] freq = new int[26];
        int[] freq2 = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            freq2[ch - 'a']++;
        }

        int minimum = Integer.MAX_VALUE;

        for (char ch : target.toCharArray()) {
            minimum = Math.min(minimum, freq[ch - 'a'] / freq2[ch - 'a']);
        }

        return minimum;
    }
}
