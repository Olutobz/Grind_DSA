package javaVersion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 13, September 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * Output: [1,2]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 * </blockquote>
 */


public class TopKFrequentElements {

    // TC -> O(n log k), SC -> O(n + k)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        if (k == nums.length) return nums;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for (int currKey : freqMap.keySet()) {
            maxHeap.offer(currKey);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            result[i] = maxHeap.poll();
        }

        return result;
    }

}
