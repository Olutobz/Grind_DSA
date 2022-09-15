import java.util.*;

/**
 * Follow-up Question (1): What if the given array is already sorted? How would you optimize your algorithm?
 * Answer -> Approach 1 is the best choice since we skip the cost of sorting.
 * So time complexity is O(M+N) and the space complexity is O(N) because of our list, however this can
 * be improved by returning an array directly from the list using Java 8 streams.
 *
 * <p>
 * Follow-up Question (2): What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * <p>
 * Answer -> Approach 2 is the best choice.
 * Time complexity is O(M+N) and the space complexity is O(M), where M is length of nums1, N is length of nums2.
 *
 * <p>
 * Follow-up Question (3): What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
 * load all elements into the memory at once?
 * <p>
 * Answer ->If nums1 fits into the memory, we can use Approach 2 which stores all elements of nums1 in the HashMap.
 * Then, we can sequentially load and process nums2.
 * If neither nums1 nor nums2 fits into the memory, we split the numeric range into numeric sub-ranges that fit into the memory.
 * We modify Approach 2 to count only elements which belong to the given numeric sub-range.
 * We process each numeric sub-ranges one by one, until we process all numeric sub-ranges.
 * <p>
 * For example:
 * Input constraint:
 * 1 <= nums1.length, nums2.length <= 10^10.
 * 0 <= nums1[i], nums2[i] < 10^5
 * Our memory can store up to 1000 elements.
 * Then we split numeric range into numeric sub-ranges [0...999], [1000...1999], ..., [99000...99999],
 * then call Approach 2 to process 100 numeric sub-ranges.
 */

public class IntersectionOfTwoArraysII {

    // TC -> O(NLogN + MLogM), SC -> O(N) (without counting output as space)
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        List<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            result[k] = intersection.get(k);
        }

        return result;
    }

    // TC -> O(N + M), SC -> O(max(N,M)) (without counting output as space)
    public int[] intersectII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }

        }

        int[] result = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            result[k] = intersection.get(k);
        }

        return result;
    }

}
