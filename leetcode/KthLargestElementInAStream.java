import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (!minHeap.isEmpty()) {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
        }

        return minHeap.peek();
    }
}
