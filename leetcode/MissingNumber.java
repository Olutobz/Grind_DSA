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
}
