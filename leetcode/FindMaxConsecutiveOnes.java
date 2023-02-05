public class FindMaxConsecutiveOnes {
    // Given a binary array nums, return the maximum number of consecutive 1's in the array.
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is null");
        }

        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else count = 0;
            max = Math.max(count, max);
        }
        return max;
    }
}
