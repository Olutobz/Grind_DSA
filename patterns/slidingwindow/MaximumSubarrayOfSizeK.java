package slidingwindow;

/**
 * Find the max sum subarray of a fixed size K.
 *
 * <blockquote>
 * <pre>
 * Example 1
 * Input: nums = [4,2,1,7,8,1,2,8,1,0],  K = 3
 * Output = 16
 * </pre>
 * </blockquote>
 */

public class MaximumSubarrayOfSizeK {

    // TC -> O(N), SC -> O(1)
    public static int findMaxSumSubArray(int[] nums, int k) {
        int maxSumSoFar = Integer.MIN_VALUE;
        int runningSum = 0;

        for (int right = 0, left = 0; right < nums.length; right++) {
            runningSum += nums[right];
            if (right >= k - 1) {
                maxSumSoFar = Math.max(maxSumSoFar, runningSum);
                runningSum -= nums[left];
                left++;
            }
        }
        return maxSumSoFar;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        System.out.println(findMaxSumSubArray(arr, k));
    }

}
