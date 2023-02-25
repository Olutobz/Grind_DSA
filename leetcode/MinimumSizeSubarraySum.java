import java.util.Arrays;

public class MinimumSizeSubarraySum {

    // TC -> O(N), SC -> O(1)
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int windowStart = 0, windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while (sum >= target) {
                min = Math.min(min, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int minSubArrayLenII(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
