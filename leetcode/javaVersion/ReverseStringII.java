package javaVersion;

public class ReverseStringII {

    // TC -> O(N), SC -> O(N)
    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) return s;
        if (k == 0) return s;
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < arr.length) {
            int j = Math.min(i + k - 1, s.length() - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return new String(arr);
    }

    // TC -> O(N), SC -> O(1)
    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // TC -> O(N), SC -> O(N)
    public String reverseStrII(String s, int k) {
        if (s == null || s.isEmpty()) return s;
        if (k == 0) return s;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < s.length()) {
            int j = Math.min(i + k - 1, s.length() - 1);
            while (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
            i += 2 * k;
        }

        return sb.toString();
    }
}
