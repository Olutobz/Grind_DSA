package java;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    // TC -> O(N), SC -> O(N)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : set1) {
            if (!set2.contains(num)) list1.add(num);
        }
        for (int num : set2) {
            if (!set1.contains(num)) list2.add(num);
        }
        result.add(list1);
        result.add(list2);
        return result;
    }

    // TC -> O(N), SC -> O(N)
    public List<List<Integer>> findDifferenceII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int j : nums2) {
            map2.put(j, map2.getOrDefault(j, 0) + 1);
        }
        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                list1.add(key);
            }
        }
        for (int key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                list2.add(key);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}
