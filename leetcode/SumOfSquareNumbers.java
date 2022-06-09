public class SumOfSquareNumbers {
    // TC -> O(C), SC -> O(1)
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
}
