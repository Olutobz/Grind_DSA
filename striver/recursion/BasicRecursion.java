package recursion;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 02, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class BasicRecursion {
    static int count = 0;

    // TC -> O(3), SC -> O(3)
    static void integerCounter() {
        if (count == 3) return;
        System.out.println(count);
        count++;
        integerCounter();
    }

    static void backTrackIntegerCounter(int i) {
        if (i < 1) return;
        backTrackIntegerCounter(i - 1);
        System.out.println(i);
    }

    // TC -> O(n), SC -> O(n)
    static void repeatName(int i, int n) {
        if (i > n) return;
        System.out.println("Toba");
        repeatName(i + 1, n);
    }

    public static void main(String[] args) {
        integerCounter();
        System.out.println();
        repeatName(1, 5);
        System.out.println();
        backTrackIntegerCounter(5);
    }

}
