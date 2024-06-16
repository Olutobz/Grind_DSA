public class CamelCase {

    // TC -> O(N), SC -> O(1)
    public static int camelcase(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char currChar : s.toCharArray()) {
            if (Character.isUpperCase(currChar)) count++;
        }
        return count;
    }
}
