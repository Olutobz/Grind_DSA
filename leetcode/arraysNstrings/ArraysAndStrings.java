package arraysNstrings;

public class ArraysAndStrings {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        leftSum[0] = nums[0];
        rightSum[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[length - 1 - i] = rightSum[length - i] + nums[length - 1 - i];
        }

        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }

        return -1;
    }


}
