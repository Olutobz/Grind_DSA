import java.util.HashSet;
import java.util.Set;

public class SumOfSquareNumbers {
    // TC -> O(C^2), SC -> O(1)
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }

    // TC -> O(sqrt(clog c)), SC -> O(1)
    public boolean judgeSquareSumII(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    // TC -> O(sqrt(Clog C)), SC -> O(1)
    public boolean judgeSquareSumIII(int c) {
        if (c < 3) return true;
        long a = 0, b = (int) Math.sqrt(c);

        while (a <= b) {
            long sum = (a * a) + (b * b);
            if (sum == c) return true;
            else if (sum < c) a++;
            else b--;
        }
        return false;
    }

    // TC -> O(sqrt c), SC -> O(N)
    public boolean judgeSquareSumIV(int c) {
        Set<Integer> set = new HashSet<>();

        for (int a = 0; a <= Math.sqrt(c); a++) {
            set.add(a * a);
            if (set.contains(c - a * a)) return true;
        }
        return false;
    }
}
