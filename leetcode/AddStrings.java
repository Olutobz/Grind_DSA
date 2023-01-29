public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            int x = (i < 0) ? 0 : num1.charAt(i--) - '0';
            int y = (j < 0) ? 0 : num2.charAt(j--) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }

        return sb.reverse().toString();
    }
}
