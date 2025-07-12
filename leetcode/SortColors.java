import java.util.Arrays;

/**
 * Given an array of nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the colors red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *  Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * </pre>
 * </blockquote>
 */

public class SortColors {

    // TC -> O(nlogn), SC -> O(1)
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // TC -> O(n), SC -> O(1)
    public void sortColorsI(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int countZeros = 0, countOnes = 0, countTwos = 0;

        for (int num : nums) {
            if (num == 0) countZeros++;
            else if (num == 1) countOnes++;
            else countTwos++;
        }

        int k = 0;
        for (int i = 0; i < countZeros; i++) {
            nums[k++] = 0;
        }

        for (int i = 0; i < countOnes; i++) {
            nums[k++] = 1;
        }

        for (int i = 0; i < countTwos; i++) {
            nums[k++] = 2;
        }
    }

    // TC -> O(n), SC -> O(1)
    public void sortColorsII(int[] nums) {
        if (nums == null || nums.length == 1) return;

        int countZeros = 0, countOnes = 0, countTwos = 0;

        for (int num : nums) {
            if (num == 0) countZeros++;
            else if (num == 1) countOnes++;
            else countTwos++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < countZeros) nums[i] = 0;
            else if (i < countZeros + countOnes) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
