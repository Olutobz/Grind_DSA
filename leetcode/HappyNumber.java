import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */

public class HappyNumber {

    // TC -> O(LogN), SC -> O(LogN)
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // TC -> O(LogN), SC -> O(1)
    public boolean isHappyII(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != slowRunner && fastRunner != 1) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n = n / 10;
        }
        return sum;
    }
}
