import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // TC -> O(N^2), SC -> O(1)
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];

    }

    // TC -> O(N), SC -> O(N)
    public int[] twoSumII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

    }

}
