public class ValidPerfectSquare {
    // TC -> O(log(num)), SC -> O(1)
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // TC -> O(log(num)), SC -> O(1)
    public boolean isPerfectSquareII(int num) {
        if (num == 0 || num == 1) return true;
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == num / mid && num % mid == 0) return true;
            else if (mid < num / mid) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
