public class NonDecreasingArray {

    /**
     * Modified Input-Array
     */
    // TC -> O(N), SC -> O(1)
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return count <= 1;
    }


    /**
     * Without modifying Input-Array
     */
    // TC -> O(N), SC -> O(1)
    public boolean checkPossibilityII(int[] nums) {
        if (nums.length < 3) {
            return true;
        }

        int count = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    continue;
                }
            }
            prev = nums[i];
        }

        return count <= 1;
    }

}
