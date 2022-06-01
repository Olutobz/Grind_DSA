import java.util.Arrays;

public class SquaresOfASortedArray {

    // TC -> O(NLogN), SC -> O(1)
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // TC -> O(N), SC -> O(N)
    public int[] sortedSquaresII(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int[] newArr = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = newArr.length - 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        while (start <= end) {
            if (nums[start] > nums[end]) {
                newArr[index] = nums[start++];
            } else {
                newArr[index] = nums[end--];
            }
            index--;
        }

        return newArr;
    }
}
