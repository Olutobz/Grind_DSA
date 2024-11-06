import java.util.Arrays;


/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * </pre>
 * </blockquote>
 */

public class SquaresOfASortedArray {

    // TC -> O(N), SC -> O(N)
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int idx = result.length - 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        while (start <= end) {
            if (nums[start] > nums[end]) {
                result[idx] = nums[start];
                start++;
            } else {
                result[idx] = nums[end];
                end--;
            }
            idx--;
        }

        return result;
    }

    // TC -> O(N), SC -> O(N)
    public int[] sortedSquaresII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int idx = nums.length - 1;

        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                result[idx] = (int) Math.pow(nums[start], 2);
                start++;
            } else {
                result[idx] = (int) Math.pow(nums[end], 2);
                end--;
            }
            idx--;
        }

        return result;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int[] sortedSquaresIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    // TC -> O(NLogN), SC -> O(N)
    public int[] sortedSquaresIV(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        int idx = 0;
        for (int num : nums) {
            result[idx] = (int) Math.pow(num, 2);
            idx++;
        }

        Arrays.sort(result);
        return result;
    }

}
