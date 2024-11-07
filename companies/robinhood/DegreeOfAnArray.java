package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 06, November 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the sub-arrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *     </pre>
 * </blockquote>
 */

public class DegreeOfAnArray {

    // TC -> O(N), SC -> O(N)
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> lastPosition = new HashMap<>();
        int minLen = 0, degree = 0;

        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (!lastPosition.containsKey(nums[i])) {
                lastPosition.put(nums[i], i);
            }
            if (countMap.get(nums[i]) > degree) {
                degree = countMap.get(nums[i]);
                minLen = i - lastPosition.get(nums[i]) + 1;
            } else if (countMap.get(nums[i]) == degree) {
                minLen = Math.min(minLen, i - lastPosition.get(nums[i]) + 1);
            }
        }

        return minLen;
    }

}
