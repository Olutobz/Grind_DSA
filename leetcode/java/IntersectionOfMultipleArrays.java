package java;

import java.util.*;

public class IntersectionOfMultipleArrays {

    // TC -> O(NLogN), SC -> O(N)
    public List<Integer> intersection(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int[] num : nums) {
            for (int val : num) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == nums.length) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }

    // TC -> O(N * M), SC -> O(1) [since the size of out freq array is fixed]
    public List<Integer> intersectionI(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new ArrayList<>();
        }

        // the row & column are of range 1 <= nums.length <= 1000
        int[] freq = new int[1001];
        List<Integer> list = new ArrayList<>();

        // since all the values of nums[i] are unique.
        for (int[] num : nums) {
            for (int val : num) {
                freq[val]++;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == nums.length) {
                list.add(i);
            }
        }

        return list;
    }

}
