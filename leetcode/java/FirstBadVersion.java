package java;

public class FirstBadVersion {

    // TC -> O(LogN), SC -> O(1)
    public int firstBadVersion(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private boolean isBadVersion(int mid) {
        // the correct impl for this function has been written by Leetcode as an API
        return true;
    }

}