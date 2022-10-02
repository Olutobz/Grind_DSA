public class FindNumbersWithEvenNumberOfDigits {

    // TC -> O(N), SC -> O(1)
    public int findNumbers(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digitCount = 0;
            while (nums[i] != 0) {
                nums[i] /= 10;
                digitCount++;
            }
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // TC -> O(N), SC -> O(1)
    public int findNumbersII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
