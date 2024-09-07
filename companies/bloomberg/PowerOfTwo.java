package bloomberg;

/*
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Tip: Always remember that bit manipulation techniques are usually based on observations from multiple examples
 * <blockquote>
 * <pre>
 * Let's take some good examples :
 * number->binary form
 * 3->0000 0011
 * 4->0000 0100
 * 5->0000 0101
 * 6->0000 0110
 * 7->0000 0111
 * 8->0000 1000
 * </pre>
 * </blockquote>
 * <p>
 * The observation we can conclude is that the number which is a power of two has always compulsorily 1 true bit.
 * <blockquote>
 * <pre>
 * Now consider :-
 * bit representation of 7  -> 0111
 * bit representation of 8  -> 1000
 * bitwise AND of 7 and 8 -> 0000
 * we are going to use this property for all numbers which are powers of two
 * </pre>
 * </blockquote>
 */

public class PowerOfTwo {

    //  TC -> O(1), SC -> O(1)
    public boolean isPowerOfTwoII(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    //  TC -> O(logN), SC -> O(1)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

}
