import java.util.PriorityQueue;

// TC -> O(NLogK), SC -> O(K)
public class KthLargestElementInAStream {
    final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    final int k;

    // TC -> O(NLogK), SC -> O(1)
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    // TC -> O(LogK), SC -> O(1)
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
