package javaVersion;

public class AddBinary {
    // TC -> O(max(M,N)), SC -> O(max(M,N))
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);

        }

        if (carry != 0) res.append(carry);
        return res.reverse().toString();

    }
}
