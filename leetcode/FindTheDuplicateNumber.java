import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

    // TC -> O(N^2), SC -> O(1)
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // TC -> O(NLogN), SC -> O(sorting), O(LogN)
    public int findDuplicateII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // TC -> O(N), SC -> O(N)
    public int findDuplicateIII(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return nums.length;
    }

    // TC -> O(N), SC -> O(N)
    public int findDuplicateIV(int[] nums) {
        int len = nums.length;
        int[] freq = new int[len + 1];

        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) {
                return num;
            }
        }
        return len;
    }

    // TC -> O(N), SC -> O(1)
    public int findDuplicateV(int[] nums) {
        int len = nums.length, duplicate = 0;

        for (int i = 0; i < len; i++) {
            int currNum = Math.abs(nums[i]);
            if (nums[currNum] < 0) {
                duplicate = currNum;
                break;
            }
            nums[currNum] = -1 * nums[currNum];
        }

        // Restore the input values
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }

}
