package slidingwindow;

/**
 * Find the max sum subarray of a fixed size K
 * Example Input:
 * [4,2,1,7,8,1,2,8,1,0],  K = 3
 */

public class MaximumSubArray {

    // TC -> O(N), SC -> O(1)
    public static int findMaxSumSubArray(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currRunningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currRunningSum += nums[i];
            if (i >= k - 1) {
                maxValue = Math.max(maxValue, currRunningSum);
                currRunningSum -= nums[i - (k - 1)];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {4,2,1,7,8,1,2,8,1,0};
        int k = 3;
        System.out.println(findMaxSumSubArray(testArr, k));
    }

}
