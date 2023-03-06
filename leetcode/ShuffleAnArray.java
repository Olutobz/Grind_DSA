import java.util.Random;

public class ShuffleAnArray {
    private final int[] nums;
    private final Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) return null;
        int[] res = nums.clone();
        for (int i = 1; i < res.length; i++) {
            int j = random.nextInt(i + 1);
            swap(res, i, j);
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
