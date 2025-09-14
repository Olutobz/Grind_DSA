package java;

/**
 * Forward declaration of guess API.
 *
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */
public class GuessNumberHigherOrLower {

    // TC -> O(LogN), SC -> O(1)
    public int guessNumber(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    // Already implemented on Leetcode as an existing API
    private int guess(int mid) {
        return 0;
    }
}