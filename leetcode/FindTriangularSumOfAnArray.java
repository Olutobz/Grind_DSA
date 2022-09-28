public class FindTriangularSumOfAnArray {

    // TC -> O(N^2), SC -> O(1)
    public int triangularSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            length--;
        }

        return nums[0];
    }

    // TC -> O(N^2), SC -> O(N) (Recursive call stack)
    public int triangularSumII(int[] nums) {
        return find(nums, nums.length);
    }

    public int find(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (arr[i] + arr[i + 1]) % 10;
        }

        return find(arr, n - 1);
    }

}
