import java.util.Arrays;

public class MajorityElement {

    // TC -> O(N^2), SC -> O(1)
    public int majorityElement(int[] nums) {
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
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

}
