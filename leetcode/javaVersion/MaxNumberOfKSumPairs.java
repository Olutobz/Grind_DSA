package javaVersion;

import java.util.HashMap;
import java.util.Map;


/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 *
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * </pre>
 * </blockquote>
 */

public class MaxNumberOfKSumPairs {
    // TC -> O(N^2), SC -> O(1)
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

    // TC -> O(N), SC -> O(N)
    public int maxOperationsII(int[] nums, int k) {
        if (nums == null || k <= 0) {
            throw new IllegalArgumentException("Input array is null");
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int diff = k - num;
            if (map.containsKey(diff)) {
                count++;
                if (map.get(diff) == 1) map.remove(diff);
                else map.put(diff, map.get(diff) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}
