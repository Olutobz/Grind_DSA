public class FindPivotIndex {

    // TC -> O(N), SC -> O(1)
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int leftSum = 0, rightSum = 0;
        for (int num : nums)
            rightSum += num;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    // TC -> O(N), SC -> O(1)
    public int pivotIndexII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == sum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
