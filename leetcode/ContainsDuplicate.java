import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    // TC -> O(N), SC -> O(N)
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (uniques.contains(num)) {
                return true;
            }
            uniques.add(num);
        }
        return false;
    }

    // TC -> O(N), SC -> O(N)
    public boolean containsDuplicateII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() < nums.length;
    }

    // TC -> O(N), SC -> O(N)
    public boolean containsDuplicateIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}
