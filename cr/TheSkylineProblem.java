import java.util.*;

public class TheSkylineProblem {

    /**
     * 1. we can visit all points in order;
     * 2. when points have the same value, higher height will shadow the lower one;
     * 3. we know whether current point is a start point or a end point based on the
     * sign of its height;
     * <p>
     * <p>
     * <p>
     * for position in sorted(all start points and all end points)
     * if this position is a start point
     * add its height
     * else if this position is a end point
     * delete its height
     * compare current max height with previous max height, if different, add
     * current position together with this new max height to our result, at the
     * same time, update previous max height to current max height;
     */


    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> list = new ArrayList<>();

        List<int[]> lines = new ArrayList<>();

        for (int[] building : buildings) {
            lines.add(new int[]{building[0], building[2]});
            lines.add(new int[]{building[1], -building[2]});
        }

        Collections.sort(lines, (a, b) -> a[0] == b[0]
                ? b[1] - a[1] :
                a[0] - b[0]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prev = 0;

        for (int[] line : lines) {
            if (line[1] > 0) {
                map.put(line[1], map.getOrDefault(line[1], 0) + 1);
            } else {
                int f = map.get(-line[1]);
                if (f == 1) map.remove(-line[1]);
                else map.put(-line[1], f - 1);
            }

            int curr = map.lastKey();
            if (curr != prev) {
                list.add(Arrays.asList(line[0], curr));
                prev = curr;
            }
        }
        return list;
    }

    public List<int[]> getSkylineII(int[][] buildings) {

        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for (int[] h : height) {
            if (h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
