public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        if (nums == null || k <= 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        int len = nums.length, count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == -1) continue;
                if (nums[i] + nums[j] == k) {
                    count++;
                    nums[i] = -1;
                    nums[j] = -1;
                }
            }
        }
        return count;
    }
}
