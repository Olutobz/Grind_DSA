/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the index's right.
 * <p>
 * If the index is on the left edge of the array, then the left sum is 0
 * because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 *
 *  Constraints:
 *  1 <= nums.length <= 104
 *  -1000 <= nums[i] <= 1000
 *
 * </pre>
 * </blockquote>
 */

public class FindPivotIndex {

    // TC -> O(N), SC -> O(1)
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == totalSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    // TC -> O(N), SC -> O(1)
    public int pivotIndexII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftSum = 0, rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    // TC -> O(N), SC -> O(N)
    public int pivotIndexIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];

        leftSum[0] = nums[0];
        rightSum[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[length - 1 - i] = rightSum[length - i] + nums[length - 1 - i];
        }

        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }
}
