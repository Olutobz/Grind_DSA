import java.util.Arrays;

public class SortColors {

    // TC -> O(NLogN), SC -> O(1)
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // TC -> O(N), SC -> O(1)
    public void sortColorsI(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) nums[i] = 0;
            else if (i < count0 + count1) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    // TC -> O(N), SC -> O(1)
    public void sortColorsII(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int i = 0;
        for (int k = 0; k < count0; k++) {
            nums[i++] = 0;
        }

        for (int k = 0; k < count1; k++) {
            nums[i++] = 1;
        }

        for (int k = 0; k < count2; k++) {
            nums[i++] = 2;
        }
    }
}
