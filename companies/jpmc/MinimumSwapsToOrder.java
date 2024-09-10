package jpmc;

import java.util.*;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 10, September 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * A shopkeeper in Hackland assigns each item in a shop a unique popularity rating.
 * To order the items in decreasing popularity from left to right, the shopkeeper can swap any 2 items in one operation.
 * Determine the minimum number of operations needed to reorder the items correctly.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * n = 4
 * Popularity = [3,4,1,2]
 *
 * First switch 3 and 4 to get popularity = [4,3,1,2]
 * Then switch 1 and 2 to get [4,3,2,1]
 * The array is reordered in 2 operations
 * </pre>
 * </blockquote>
 */

public class MinimumSwapsToOrder {

    // TC -> O(n log n), SC -> O(n)
    private int minimumSwaps(List<Integer> popularity) {
        if (popularity.isEmpty()) return 0;

        Map<Integer, Integer> originalIndices = new HashMap<>();
        int n = popularity.size();
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            originalIndices.put(popularity.get(i), i);
        }

        List<Integer> sortedPopularity = new ArrayList<>(popularity);
        sortedPopularity.sort(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (visited[i] || originalIndices.get(sortedPopularity.get(i)) == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = originalIndices.get(sortedPopularity.get(j));
                cycleSize++;
            }

            if (cycleSize > 1) {
                count += cycleSize - 1;
            }
        }

        return count;
    }

    // TC -> O(n log n), SC -> O(n)
    private static int minimumSwapsII(List<Integer> popularity) {
        if (popularity.isEmpty()) return 0;

        List<int[]> originalIndices = new ArrayList<>();
        int n = popularity.size();
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            originalIndices.add(new int[]{popularity.get(i), i});
        }

        originalIndices.sort((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            if (visited[i] || originalIndices.get(i)[1] == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = originalIndices.get(i)[1];
                cycleSize++;
            }

            if (cycleSize > 1) {
                count += cycleSize - 1;
            }
        }

        return count;
    }

}
