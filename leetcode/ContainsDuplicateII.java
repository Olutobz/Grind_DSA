import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    // TC -> O(N^2), SC -> O(1)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // TC -> O(N), SC -> O(N)
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // TC -> O(N), SC -> O(min(N, K+1))
    public boolean containsNearbyDuplicateIII(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
