
/*  The number 1112221111 can be read out as "one, one, one, two, ..." etc: saying each digit from left to right.
    However, we could be more efficient by grouping like digits. In this case: "three ones, three twos, four ones."
    This leads to the encoding 313241 (read it out loud!).
    Write a program to encode integers in this way.

    Note: consider the speed of your program: try to avoid expensive string operations.
    111222. -> 3132
    3, 1, 3, 2 -->. 3132

    O(1) space
    Any ideas?
*/


public class EncodeIntegers {

    private static int encodeInt(int num) {
        if (num < 0) throw new IllegalArgumentException("Enter a valid integer number");
        StringBuilder encodedStr = new StringBuilder();
        String numStr = num + "";
        int digitCount = 1;
        char prevDigit = numStr.charAt(0);

        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) == prevDigit) {
                digitCount++;
            } else {
                encodedStr.append(digitCount).append(prevDigit);
                digitCount = 1;
                prevDigit = numStr.charAt(i);
            }
        }
        encodedStr.append(digitCount).append(prevDigit);
        return Integer.parseInt(encodedStr.toString());

    }


}