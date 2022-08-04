package arraysNstrings;

public class ArraysAndStrings {

    // TC -> O(N) SC -> O(N)
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        leftSum[0] = nums[0];
        rightSum[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[length - 1 - i] = rightSum[length - i] + nums[length - 1 - i];
        }

        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }

        return -1;
    }

    // TC -> O(N) SC -> O(1)
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

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int maxElem = Integer.MIN_VALUE, maxIndex = -1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElem) {
                maxElem = nums[i];
                maxIndex = i;
            }
        }

        for (int num : nums) {
            if (maxElem >= num * 2) count++;
        }

        if (count == nums.length - 1) return maxIndex;

        return -1;
    }

    public int dominantIndexII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int max1 = 0, max2 = 0, maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return (max1 >= max2 * 2) ? maxIndex : -1;
    }


}
