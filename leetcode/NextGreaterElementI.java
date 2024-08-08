/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 07, August 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element
 * that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
 * and determine the next greater element of nums2[j] in nums2. If there is no next greater element,
 * then the answer for this query is -1.
 * <p>
 * Return an array 'ans' of length nums1.length such that ans[i] is the next greater element as described above.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1
 *     </pre>
 * </blockquote>
 */


public class NextGreaterElementI {

    // TC -> O(N), SC -> O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int i = 0;
        for (int num : nums1) {
            ans[i] = map.getOrDefault(num, -1);
            i++;
        }

        return ans;
    }

    // TC -> O(N^2), SC -> O(1)
    private int[] nextGreaterElementII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int greaterElem = -1;
            for (int j = nums2.length - 1; j >= 0 && nums1[i] != nums2[j]; j--) {
                if (nums2[j] > nums1[i]) {
                    greaterElem = nums2[j];
                }
            }
            ans[i] = greaterElem;
        }

        return ans;
    }

}
