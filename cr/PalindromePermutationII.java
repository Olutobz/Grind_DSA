import java.util.LinkedList;
import java.util.List;

public class PalindromePermutationII {

    /**
     * Given a string s, return all the palindromic permutations (without duplicates) of it.
     * Return an empty list if no palindromic permutation could be form.
     * <p>
     * Example 1:
     * Input: "aabb"
     * Output: ["abba", "baab"]
     * <p>
     * Example 2:
     * Input: "abc"
     * Output: []
     */

    public List<String> generatePalindromes(String s) {
        int[] charInts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            charInts[s.charAt(i)] += 1;
        }

        List<String> result = new LinkedList<>();
        boolean odd = false;
        int oddIndex = 0;
        for (int i = 0; i < 256; i++) {
            if (charInts[i] % 2 == 1) {
                if (odd) {
                    return result;
                }
                oddIndex = i;
                odd = true;
            }
        }

        String str = "";
        if (odd) {
            str = (char) oddIndex + "";
            charInts[oddIndex] -= 1;
        }
        process(str, charInts, s.length(), result);
        return result;
    }

    private void process(String str, int[] cha, int n, List<String> result) {
        if (str.length() == n) {
            result.add(str);
            return;
        }
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] > 0) {
                cha[i] -= 2;
                process((char) i + str + (char) i, cha, n, result);
                cha[i] += 2;
            }
        }
    }

}
