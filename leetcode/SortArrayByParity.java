public class SortArrayByParity {

    // TC -> O(N), SC -> O(1)
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null) return null;
        for (int readIndex = 0, writeIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] % 2 == 0) {
                int temp = nums[writeIndex];
                nums[writeIndex++] = nums[readIndex];
                nums[readIndex] = temp;
            }
        }
        return nums;
    }
}
