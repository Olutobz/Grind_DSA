package javaVersion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

    // TC -> O(NLogN), SC -> O(1)
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int count = 1;

        Arrays.sort(nums);
        if (length < 3) return nums[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) count++;
            if (count == 3) return nums[i];
        }

        return nums[length - 1];
    }

    // TC -> O(N), SC -> O(N)
    private int thirdMaxII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (set.contains(num)) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            set.add(num);
        }

        return (set.size() >= 3) ? max3 : max1;
    }
}
