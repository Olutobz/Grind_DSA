package javaVersion;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    static class MedianFinder {

        private final Queue<Integer> minHeap;
        private final Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        // TC -> O(LogK), SC -> O(1)
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // TC -> O(1), SC -> O(1)
        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else if (minHeap.size() > maxHeap.size()) {
                return (double) minHeap.peek();
            } else {
                return (double) maxHeap.peek();
            }
        }
    }
}
