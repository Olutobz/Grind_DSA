package java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {

    // TC -> O(N), SC -> O(1) [assume the returned list does not count as extra space]
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<Integer> missing = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = (nums[index] > 0) ? -1 * nums[index] : nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missing.add(i + 1);
        }

        return missing;
    }

    // TC -> O(N), SC -> O(N)
    public List<Integer> findDisappearedNumbersII(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<Integer> missing = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!(set.contains(i + 1))) missing.add(i + 1);
        }
        return missing;
    }

}
