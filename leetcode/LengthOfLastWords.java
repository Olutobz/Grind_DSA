public class LengthOfLastWords {

    // TC -> O(1), SC -> O(1)
    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        s = strArr[strArr.length - 1];
        return s.length();
    }

}
