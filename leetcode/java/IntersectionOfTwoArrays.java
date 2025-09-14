package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // TC -> O(N + M), SC -> O(max(N,M))
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for (int val : intersection) {
            result[i++] = val;
        }

        return result;
    }

    // TC -> O(NLogN + MLogM), SC -> O(max(N,M))
    public int[] intersectionII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[set.size()];
        for (int val : set) {
            result[k++] = val;
        }
        return result;
    }

    // TC -> O(NLogN + MLogM), SC -> O(N) [without counting output as space]
    public int[] intersectionIII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();

        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int val : set) {
            result[k++] = val;
        }
        return result;

    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}
