package arrays;

public class Arrays101 {

    // Given a binary array nums, return the maximum number of consecutive 1's in the array.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else if (num == 1) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

}
