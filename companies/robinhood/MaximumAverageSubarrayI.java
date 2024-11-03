package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 03, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10^-5 will be accepted.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * Constraints:
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 * </pre>
 * </blockquote>
 */

public class MaximumAverageSubarrayI {

    // TC -> O(n), SC -> O(1)
    public double findMaxAverage(int[] nums, int k) {
        int runningSum = 0;
        int max = Integer.MIN_VALUE;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            runningSum += nums[right];
            if (right - left + 1 > k) {
                runningSum -= nums[left];
                left++;
            }
            if (right >= k - 1) {
                max = Math.max(max, runningSum);
            }
        }

        return (double) max / k;
    }

    // TC -> O(n), SC -> O(1)
    public double findMaxAverageII(int[] nums, int k) {
        double maxSum = Double.NEGATIVE_INFINITY;
        int left = 0;
        int runningSum = 0;

        for (int right = 0; right < nums.length; right++) {
            runningSum += nums[right];
            if (right - left + 1 > k) {
                runningSum -= nums[left];
                left++;
            }
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, runningSum);
            }
        }

        return maxSum / k;
    }

}
