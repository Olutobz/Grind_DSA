public class CamelCase {

    // TC -> O(N), SC -> O(N)
    public static int camelcase(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        char[] charArr = s.toCharArray();
        for (char currChar : charArr) {
            if (Character.isUpperCase(currChar)) count++;
        }
        return count;
    }
}
