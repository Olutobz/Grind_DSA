public class CamelCase {

    // TC -> O(N), SC -> O(N)
    public static int camelcase(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (char currChar : chars) {
            if (Character.isUpperCase(currChar)) count++;
        }
        return count;
    }
}
