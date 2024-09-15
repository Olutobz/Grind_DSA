import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 13, September 2024
 * EMAIL: damexxey94@gmail.com
 */

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            maxHeap.add(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }

}
