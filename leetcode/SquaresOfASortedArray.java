import java.util.Arrays;

public class SquaresOfASortedArray {

    // TC -> O(NLogN), SC -> O(1)
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // TC -> O(NLogN), SC -> O(N)
    public int[] sortedSquaresII(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] newArr = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            newArr[index] = (int) Math.pow(num, 2);
            index++;
        }
        Arrays.sort(newArr);
        return newArr;
    }

    // TC -> O(N), SC -> O(N)
    public int[] sortedSquaresIII(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int[] newArr = new int[nums.length];
        int start = 0, end = nums.length - 1;
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

    // TC -> O(N), SC -> O(N)
    public int[] sortedSquaresIV(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] newArr = new int[nums.length];
        int start = 0, end = nums.length - 1, index = nums.length - 1;

        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                newArr[index] = (int) Math.pow(nums[start], 2);
                start++;
            } else {
                newArr[index] = (int) Math.pow(nums[end], 2);
                end--;
            }
            index--;
        }
        return newArr;
    }

}
