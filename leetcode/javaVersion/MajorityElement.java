package javaVersion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * </pre>
 * </blockquote>
 */


public class MajorityElement {

    // TC -> O(n^2), SC -> O(1)
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (num == elem) count++;
            }
            if (count > nums.length / 2) return num;
        }

        return -1;
    }

    // TC -> O(nlogn), SC -> O(1)
    public int majorityElementI(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // TC -> O(n), SC -> O(n)
    public int majorityElementII(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int res = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > maxCount) {
                maxCount = countMap.get(num);
                res = num;
            }
        }

        return res;
    }

    // TC -> O(n), SC -> O(n)
    public int majorityElementIII(int[] nums) {
        if (nums.length == 1) return nums[0];

        int majorElem = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majorElem) {
                majorElem = num;
                break;
            }
        }

        return majorElem;
    }

    // TC -> O(n), SC -> O(1)
    /* Boyer–Moore majority vote algorithm */
    public int majorityElementIV(int[] nums) {
        if (nums.length == 1) return nums[0];

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

}
