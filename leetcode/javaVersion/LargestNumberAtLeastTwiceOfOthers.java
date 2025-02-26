package javaVersion;

public class LargestNumberAtLeastTwiceOfOthers {

    // TC -> O(N), SC -> O(1)
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                idx = i;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return max1 >= max2 * 2 ? idx : -1;
    }

    // TC -> O(N), SC -> O(1)
    public int dominantIndexII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int maxElem = Integer.MIN_VALUE, maxIndex = -1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElem) {
                maxElem = nums[i];
                maxIndex = i;
            }
        }
        for (int num : nums) {
            if (maxElem >= num * 2) count++;
        }

        return count == nums.length - 1 ? maxIndex : -1;
    }

}
