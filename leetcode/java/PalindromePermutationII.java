package java;

import java.util.*;

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

        List<String> result = new ArrayList<>();

        int odd = 0;

        // char => its count
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, 1 + map.getOrDefault(c, 0));
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) {
            return result;
        }

        // step 2. add half count of each character to list
        StringBuilder mid = new StringBuilder();
        List<Character> charList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) { // odd count char
                mid.append(key);
            }

            for (int i = 0; i < val / 2; i++) {
                charList.add(key);
            }
        }

        // step 3. generate all the permutations
        getPerm(charList, mid.toString(), new boolean[charList.size()], new StringBuilder(), result);

        return result;
    }

    // generate all unique permutation from list, sb: cur_res
    void getPerm(List<Character> list, String midChar, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            result.add(sb + midChar + sb.reverse());
            sb.reverse(); // restore
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            // i-1 must already checked, so skip used[i - 1]==false
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                // recursion
                getPerm(list, midChar, used, sb, result);
                // backtracking
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> generatePalindromesII(String s) {
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
