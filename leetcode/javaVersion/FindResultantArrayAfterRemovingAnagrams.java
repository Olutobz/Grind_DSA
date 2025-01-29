package javaVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.
 * In one operation, select any index i such that 0 < i < words.length and words[i - 1]
 * and words[i] are anagrams, and delete words[i] from words.
 * Keep performing this operation as long as you can select an index that satisfies the conditions.
 * Return words after performing all operations. It can be shown that selecting the indices
 * for each operation in any arbitrary order will lead to the same result.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase using all the original letters exactly once.
 * For example, "dacb" is an anagram of "abdc".
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: words = ["abba","baba","bbaa","cd","cd"]
 * Output: ["abba","cd"]
 * Explanation:
 * One of the ways we can obtain the resultant array is by using the following operations:
 * - Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
 *   Now words = ["abba","baba","cd","cd"].
 * - Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
 *   Now words = ["abba","cd","cd"].
 * - Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
 *   Now words = ["abba","cd"].
 * We can no longer perform any operations, so ["abba","cd"] is the final answer.
 *
 * Example 2:
 * Input: words = ["a","b","c","d","e"]
 * Output: ["a","b","c","d","e"]
 * Explanation:
 * No two adjacent strings in words are anagrams of each other, so no operations are performed.
 *
 *
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * </pre>
 * </blockquote>
 */

public class FindResultantArrayAfterRemovingAnagrams {

    // TC -> O(n^2), SC -> O(1)
    public List<String> removeAnagramsII(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        res.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], res.get(res.size() - 1))) {
                res.add(words[i]);
            }
        }

        return res;
    }

    // TC -> O(n^2), SC -> O(n)
    public List<String> removeAnagramsIII(String[] words) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = words.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && isAnagram(words[i], stack.peek())) {
                stack.pop();
            }
            stack.push(words[i]);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }


    // TC -> O(K * n log n), SC -> O(n)
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null) {
            return res;
        }
        String prev = "";
        for (String word : words) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if (!curr.equals(prev)) {
                res.add(word);
                prev = curr;
            }
        }
        return res;
    }

    // TC -> O(n), SC -> O(1)
    private boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            freq[t.charAt(j) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
