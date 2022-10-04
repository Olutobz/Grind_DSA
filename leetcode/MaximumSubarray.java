public class MaximumSubarray {

    // TC -> O(N^2), SC -> O(1)
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, runningSum = 0; j < nums.length; j++) {
                runningSum += nums[j];
                maxSoFar = Math.max(maxSoFar, runningSum);
            }
        }
        return maxSoFar;
    }

}
