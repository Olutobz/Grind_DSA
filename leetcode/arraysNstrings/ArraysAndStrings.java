package arraysNstrings;

public class ArraysAndStrings {

    // TC -> O(sqrt(x)), SC -> O(1)
    public int mySqrt(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x / i; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1))
                return i;
        }
        return -1;
    }

    // TC -> O(log x), SC -> O(1)
    public int mySqrtII(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if (mid > x / mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

}
