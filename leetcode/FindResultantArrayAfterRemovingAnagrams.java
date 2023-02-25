import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindResultantArrayAfterRemovingAnagrams {

    // TC -> O(K*NLogN), SC -> O(1)
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

    // TC -> O(N^2), SC -> O(1)
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

    // TC -> O(N^2), SC -> O(N)
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

    // TC -> O(N), SC -> O(26)
    private boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
