package slidingWindow;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 30, October 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Example 1: Given an array of positive integers nums and an integer k,
 * find the length of the longest subarray whose sum is less than or equal to k.
 *
 * <blockquote>
 * <pre>
 * nums = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8.
 * output = 4
 * </pre>
 * </blockquote>
 */

public class LengthOfLongestSubarray {

    // TC -> O(n), SC -> O(1)
    private int findLength(int[] nums, int k) {
        int maxWindowLen = 0;
        int left = 0;
        int runningSum = 0;

        for (int right = 0; right < nums.length; right++) {
            runningSum += nums[right];
            while (runningSum > k) {
                runningSum -= nums[left];
                left++;
            }
            maxWindowLen = Math.max(maxWindowLen, right - left + 1);
        }

        return maxWindowLen;
    }

}
