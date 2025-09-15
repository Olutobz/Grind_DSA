package java;

import java.util.Arrays;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 30, August 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an integer array nums, return the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * Example 2:
 * Input: nums = [4,2,3,4]
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * </pre>
 * </blockquote>
 */

public class ValidTriangleNumber {

    // TC -> O(n^2), SC -> O(1)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            int l = 0;
            int r = k - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[k]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return count;
    }
}
