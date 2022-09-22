public class CamelCase {

    // TC -> O(N), SC -> O(N)
    public static int camelcase(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                count++;
            }
        }
        return count + 1;
    }

}
