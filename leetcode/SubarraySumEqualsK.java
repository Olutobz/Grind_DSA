/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 30, October 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * </pre>
 * </blockquote>
 */

public class SubarraySumEqualsK {

    // TC -> O(n), SC -> O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // TC -> O(n^2), SC -> O(n)
    public int subarraySumII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        for (int start = 0; start < prefixSum.length; start++) {
            if (prefixSum[start] == k) {
                count++;
            }
            for (int end = start + 1; end < prefixSum.length; end++) {
                if (prefixSum[end] - prefixSum[start] == k) {
                    count++;
                }
            }
        }

        return count;
    }

}
