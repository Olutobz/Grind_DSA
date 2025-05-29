package javaVersion;

public class StringCompression {

    // TC -> O(N), SC -> O(1)
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int left = 0, right = 0, idx = 0;
        while (left < chars.length) {
            while (right < chars.length && chars[right] == chars[left]) {
                right++;
            }
            int freq = right - left;
            chars[idx++] = chars[left];
            if (freq > 1) {
                String str = String.valueOf(freq);
                for (int i = 0; i < str.length(); i++) {
                    chars[idx++] = str.charAt(i);
                }
            }
            left = right;
        }

        return idx;
    }
}
