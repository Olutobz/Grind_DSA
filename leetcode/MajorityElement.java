import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MajorityElement {

    // TC -> O(n^2), SC -> O(1)
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (num == elem) count++;
            }
            if (count > nums.length / 2) return num;
        }

        return -1;
    }

    // TC -> O(nlogn), SC -> O(1)
    public int majorityElementI(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // TC -> O(n), SC -> O(n)
    public int majorityElementII(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int res = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > maxCount) {
                maxCount = countMap.get(num);
                res = num;
            }
        }

        return res;
    }

    // TC -> O(n), SC -> O(n)
    public int majorityElementIII(int[] nums) {
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

    // TC -> O(n), SC -> O(1)
    /* Boyer–Moore majority vote algorithm */
    public int majorityElementIV(int[] nums) {
        if (nums.length == 1) return nums[0];
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

}
