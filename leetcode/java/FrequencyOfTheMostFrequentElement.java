package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 14, July 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 *
 * Example 2:
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 *
 * Example 3:
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 *  </pre>
 * </blockquote>
 */
public class FrequencyOfTheMostFrequentElement {

    // TC -> O(NlogN), SC -> O(log N)
    public int maxFrequency(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int left = 0;
        long sumOfElemsInWindow = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            sumOfElemsInWindow += target;

            while ((long) (right - left + 1) * target - sumOfElemsInWindow > k) {
                sumOfElemsInWindow -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    // TC -> O(NlogN), SC -> O(log N)
    public int maxFrequencyII(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int left = 0, right = 0;
        long sumOfElemsInWindow = 0;

        while (right < nums.length) {
            sumOfElemsInWindow += nums[right];
            long requireSum = (long) (right - left + 1) * nums[right];
            long diff = requireSum - sumOfElemsInWindow;

            if (diff > k) {
                sumOfElemsInWindow -= nums[left];
                left++;
            }

            right++;
        }

        return right - left;
    }

}