package java;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProductOfKNumbers {

    // TC -> O(NLogK), SC -> O(K)
    private int maximumProductKNums(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            if (maxHeap.size() > k) {
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

        /*
        int allRight = 1;
        int allLeft = 1;

        while (!minHeap.isEmpty()) {
            allRight *= minHeap.poll();
        }

        allRight *= minHeap.peek();
        int neg = maxHeap.poll();
        while (maxHeap.size() > 0) {
            allLeft *= maxHeap.poll();
        }
        return Math.max(Math.max(allRight, allLeft * neg), allLeft * minHeap.peek());*/
    }
}
