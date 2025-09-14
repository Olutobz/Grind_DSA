package java;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a non-negative integer array nums. In one operation, you must:
 * <p>
 * Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
 * Subtract x from every positive element in nums.
 * Return the minimum number of operations to make every element in nums equal to 0.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,5,0,3,5]
 * Output: 3
 * Explanation:
 * In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
 * In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
 * In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
 *
 * Example 2:
 * Input: nums = [0]
 * Output: 0
 * Explanation: Each element in nums is already 0 so no operations are needed.
 * </pre>
 * </blockquote>
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    // TC -> O(N), SC -> O(N)
    private int minimumOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }


    // TC -> O(N), SC -> O(1)
    private int minimumOperationsII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        boolean flag = true;

        while (true) {
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int num : nums) {
                sum += num;
            }

            if (sum == 0) flag = false;
            if (!flag) break;

            for (int num : nums) {
                if (num != 0) {
                    min = Math.min(min, num);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] -= min;
                }
            }

            count++;
        }
        return count;
    }
}
