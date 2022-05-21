public class SquaresOfASortedArray {
    // TC -> O(N), SC -> O(1) (output array is ignored)
    public int[] sortedSquares(int[] nums) {
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
