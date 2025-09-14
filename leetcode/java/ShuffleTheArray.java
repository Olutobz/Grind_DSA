package java;

public class ShuffleTheArray {

    // TC -> O(N), SC -> O(1)
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) return new int[]{};
        for (int i = n; i < nums.length; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }
        int idx = 0;
        for (int i = n; i < nums.length; i++, idx += 2) {
            nums[idx] = nums[i] % 1024;
            nums[idx + 1] = nums[i] / 1024;
        }
        return nums;
    }

    // TC -> O(N), SC -> O(N)
    public int[] shuffleII(int[] nums, int n) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] res = new int[n * 2];
        int idx = 0;
        for (int i = 0, j = n; idx < res.length; i++, j++) {
            res[idx++] = nums[i];
            res[idx++] = nums[j];
        }

        return res;
    }

    // TC -> O(N), SC -> O(N)
    public int[] shuffleIII(int[] nums, int n) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] res = new int[n * 2];
        for (int i = 0; i < nums.length; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i];
        }

        return res;
    }

}
