package javaVersion;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * </pre>
 * </blockquote>
 */

public class MaximumSubarray {

    // TC -> O(N), SC -> O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int largestSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for (int num : nums) {
            runningSum += num;
            largestSum = Math.max(largestSum, runningSum);
            if (runningSum < 0) {
                runningSum = 0;
            }
        }

        return largestSum;
    }


    // TC -> O(N^2), SC -> O(1)
    public int maxSubArrayII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int runningSum = 0;
            for (int j = i; j < nums.length; j++) {
                runningSum += nums[j];
                largestSum = Math.max(largestSum, runningSum);
            }
        }

        return largestSum;
    }

}
