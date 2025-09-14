package java;

public class MissingNumber {

    // TC -> O(N), SC -> O(1)
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length, totalSum = 0, sum = 0;

        for (int i = 0; i <= n; i++) {
            totalSum += i;
        }
        for (int num : nums) {
            sum += num;
        }
        return totalSum - sum;
    }

    // TC -> O(N), SC -> O(1)
    public int missingNumberII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length, sum = 0;
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

    // TC -> O(N), SC -> O(1)
    public int missingNumberIII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i]; // a^b^b = a
        }
        return xor;
    }
}
