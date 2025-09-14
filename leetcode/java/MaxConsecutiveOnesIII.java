package java;

public class MaxConsecutiveOnesIII {

    // TC -> O(N), SC -> O(1)
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int zeroCount = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            max = Math.max(j - i + 1, max);
        }

        return max;
    }
}
