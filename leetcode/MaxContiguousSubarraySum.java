public class MaxContiguousSubarraySum {

    // TC -> O(N), SC -> O(1)
    public int maxContiguousSubarraySum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);

            // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // TC -> O(N^2), SC -> O(1)
    public int maxContiguousSubarraySumII(int[] nums) {
        int n = nums.length;

        // Initialise the variable with minimum integer value
        int maximumSubArraySum = Integer.MIN_VALUE;

        // Left will be the starting index of subarray
        for (int left = 0; left < n; left++) {
            int runningWindowSum = 0;

            // Right will be the ending index of subarray
            for (int right = left; right < n; right++) {

                // Add the current element to previous computed value
                // To get the subarray sum
                runningWindowSum += nums[right];

                // Does this window beat the best sum we have seen so far?
                maximumSubArraySum = Math.max(maximumSubArraySum, runningWindowSum);
            }
        }

        return maximumSubArraySum;
    }

    // TC -> O(N^3), SC -> O(1)
    public int maxContiguousSubarraySumIII(int[] nums) {
        int maximumSubArraySum = Integer.MIN_VALUE;

        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                int windowSum = 0;

                // Add all items in the window
                for (int k = left; k <= right; k++) {
                    windowSum += nums[k];
                }
                maximumSubArraySum = Math.max(maximumSubArraySum, windowSum);
            }
        }

        return maximumSubArraySum;
    }

}
