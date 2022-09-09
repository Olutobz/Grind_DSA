public class ProductOfArrayExceptSelf {

    // TC -> O(N), SC -> O(N)
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int k = 0; k < length; k++) {
            answer[k] = left[k] * right[k];
        }

        return answer;

    }

    // TC -> O(N), SC -> O(1) (If we ignore the returned array)
    public int[] productExceptSelfII(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];

        for (int i = 0, temp = 1; i < length; i++) {
            arr[i] = temp;
            temp *= nums[i];
        }
        for (int i = length - 1, temp = 1; i >= 0; i--) {
            arr[i] *= temp;
            temp *= nums[i];
        }
        return arr;
    }

}
