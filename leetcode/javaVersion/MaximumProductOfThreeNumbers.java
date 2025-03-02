package javaVersion;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProductOfThreeNumbers {

    // TC -> O(N), SC -> O(1)
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

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

    // TC -> O(NLogN), SC -> O(1)
    public int maximumProductII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    // TC -> O(NLogK), SC -> O(K)
    public int maximumProductIII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
            if (maxHeap.size() > 2) {
                maxHeap.poll();
            }
        }

        int max = 1;
        int intNum = 0;

        while (!minHeap.isEmpty()) {
            intNum = minHeap.poll();
            max *= intNum;
        }

        while (!maxHeap.isEmpty()) {
            intNum *= maxHeap.poll();
        }

        return Math.max(max, intNum);
    }

}
