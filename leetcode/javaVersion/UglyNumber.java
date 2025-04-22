package javaVersion;

public class UglyNumber {

    // TC -> O(LogN), SC -> O(1)
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    // TC -> O(LogN), SC -> O(1)
    public boolean isUglyII(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }
        return true;
    }

}
