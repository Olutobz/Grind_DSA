package arraysNstrings;

import java.util.Arrays;

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

    @SuppressWarnings("DuplicatedCode")
    private int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public int maximumProductII(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

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

    public int[] productExceptSelfII(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];

        for (int i = 0, temp = 1; i < length; i++) {
            left[i] = temp;
            temp *= nums[i];
        }

        for (int i = length - 1, temp = 1; i >= 0; i--) {
            left[i] *= temp;
            temp *= nums[i];
        }

        return left;
    }

}
