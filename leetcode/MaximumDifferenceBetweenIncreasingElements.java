public class MaximumDifferenceBetweenIncreasingElements {

    // TC -> O(N), SC -> O(1)
    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;

        int maxDiff = -1, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            maxDiff = Math.max(maxDiff, nums[i] - min);
        }

        return maxDiff == 0 ? -1 : maxDiff;
    }
}
