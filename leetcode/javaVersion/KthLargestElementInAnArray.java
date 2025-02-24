package javaVersion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    // TC -> O(NLogN), SC -> O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // TC -> O(NLogK), SC -> O(K)
    public int findKthLargestII(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : nums) {
            minHeap.offer(val);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // TC -> O(N), SC -> O(1)
    public int findKthLargestIII(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start;
        int temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            swap(nums, start, end);
        }
        swap(nums, end, pivot);
        return end;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
