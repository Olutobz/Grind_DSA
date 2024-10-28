package twoPointers;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 25, October 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target, false otherwise.
 * This problem is similar to Two Sum. (In Two Sum, the input is not sorted).
 * <p>
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13
 * return true because 4 + 9 = 13.
 * </pre>
 * </blockquote>
 */

public class TwoSumSorted {

    public boolean checkForTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return true;
            }

            if (curr > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}
