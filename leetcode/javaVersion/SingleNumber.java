package javaVersion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    // TC -> O(N^2), SC -> O(1)
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = 0;
        for (int num : nums) {
            int count = 0;
            for (int copy : nums) {
                if (num == copy) count++;
            }

            if (count == 1) {
                result = num;
            }
        }
        return result;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int singleNumberII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    // TC -> O(N), SC -> O(N)
    public int singleNumberIII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }

    // TC -> O(N), SC -> O(1)
    public int singleNumberIV(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
