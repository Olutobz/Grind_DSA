public class LargestNumberAtLeastTwiceOfOthers {

    // TC -> O(N), SC -> O(1)
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

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
}
