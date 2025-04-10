package javaVersion; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays
 * where the product of all the elements in the subarray is strictly less than k.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * </pre>
 * </blockquote>
 */

public class SubarrayProductLessThanK {

    // TC -> O(n), SC -> O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        int totalCount = 0;
        int product = 1;

        for (int right = 0, left = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            totalCount += right - left + 1;
        }

        return totalCount;
    }
}
