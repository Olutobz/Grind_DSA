package slidingWindow;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 08, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given an integer array nums and an integer k,
 * find the sum of the subarray with the largest sum whose length is k
 *
 * <blockquote>
 * <pre>
 * Example:
 * Input : [3,-1,4,12,-8,5,6], k = 4
 * Output: 18
 * </pre>
 * </blockquote>
 */

public class LengthOfSubarrayWithFixedK {

    // TC -> O(n), SC -> O(1)
    public int findBestSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int curr = 0;

        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            sum = Math.max(sum, curr);
        }

        return sum;
    }
}
