package java;

public class MaxContiguousSubarraySum {

    // TC -> O(N), SC -> O(1)
    public int maxContiguousSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int runningSum = nums[0];
        for (int start = 1; start < nums.length; start++) {
            runningSum += nums[start];
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    // TC -> O(N^2), SC -> O(1)
    public int maxContiguousSubarraySumII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < nums.length; left++) {
            int runningSum = 0;
            for (int right = left; right < nums.length; right++) {
                runningSum += nums[right];
            }
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }

    // TC -> O(N^3), SC -> O(1)
    public int maxContiguousSubarraySumIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                int runningSum = 0;
                for (int k = left; k <= right; k++) {
                    runningSum += nums[k];
                }
                maxSum = Math.max(maxSum, runningSum);
            }
        }

        return maxSum;
    }

}
