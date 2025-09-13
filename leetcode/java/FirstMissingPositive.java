package java;

import java.util.Arrays;

public class FirstMissingPositive {

    // TC -> O(NlogN), SC -> O(sorting)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num < 1) continue;
            else {
                if (num == res) {
                    res++;
                } else if (num > res) {
                    return res;
                }
            }
        }
        return res;
    }

    // TC -> O(N), SC -> O(1)
    public int firstMissingPositiveII(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }

        // all the elems are +ve at this point
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num > len) continue;
            num--;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return len + 1;
    }

}
