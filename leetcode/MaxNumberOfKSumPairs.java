import java.util.HashMap;
import java.util.Map;

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

    public int maxOperationsII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int res = k - num;
            if (map.containsKey(res)) {
                count++;
                if (map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
