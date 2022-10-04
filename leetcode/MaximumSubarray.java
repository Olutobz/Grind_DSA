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

    // TC -> O(N), SC -> O(1)
    public int maxSubArrayII(int[] nums) {
        int sum = 0, maxSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSoFar = Math.max(maxSoFar, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSoFar;
    }

}
