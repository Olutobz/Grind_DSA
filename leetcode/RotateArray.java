public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;

        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
