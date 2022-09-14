import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // TC -> O(N^2), SC -> O(1)
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int majorElem = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (num == elem) {
                    count++;
                }
            }

            if (count > majorElem) {
                return num;
            }
        }

        return -1;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int majorityElementI(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // TC -> O(N), SC -> O(N)
    public int majorityElementII(int[] nums) {
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

    // TC -> O(N), SC -> O(1)
    /* Boyer–Moore majority vote algorithm */
    public int majorityElementIII(int[] nums) {
        if (nums.length == 1) return nums[0];
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate != num) ? -1 : 1;
        }

        return candidate;
    }

}
