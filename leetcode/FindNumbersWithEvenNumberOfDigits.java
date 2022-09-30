public class FindNumbersWithEvenNumberOfDigits {

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

    public int findNumbersII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
