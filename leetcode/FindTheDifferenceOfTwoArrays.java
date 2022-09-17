import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    // TC -> O(N), SC -> O(N)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
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
    public List<List<Integer>> findDifferenceI(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> l1 = new HashMap<>();
        HashMap<Integer, Integer> l2 = new HashMap<>();
        for (int i : nums1) {
            l1.put(i, l1.getOrDefault(i, 0) + 1);
        }
        for (int j : nums2) {
            l2.put(j, l2.getOrDefault(j, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        for (int key : l1.keySet()) {
            if (!l2.containsKey(key)) {
                list1.add(key);
            }
        }
        for (int key : l2.keySet()) {
            if (!l1.containsKey(key)) {
                list2.add(key);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }

}
