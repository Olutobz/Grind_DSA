package java;

public class FindMinimumInRotatedSortedArray {

    // TC -> O(N), SC -> O(1)
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];

        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }

        return min;
    }

    // TC -> O(LogN), SC -> O(1)
    public int findMinII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            }
        }

        return nums[start];
    }
}
