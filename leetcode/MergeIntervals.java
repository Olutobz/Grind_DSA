import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // TC -> O(nlogn), SC -> O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> res = new ArrayList<>();

        int endIndex = 0, startIndex = 0;
        while (endIndex < n) {
            if (endIndex == n - 1 || starts[endIndex + 1] > ends[endIndex]) {
                res.add(new int[]{starts[startIndex], ends[endIndex]});
                startIndex = endIndex + 1;
            }
            endIndex++;
        }

        return res.toArray(new int[res.size()][]);
    }

    // TC -> O(nlogn), SC -> O(n)
    public List<int[]> merge(List<int[]> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i)[0];
            ends[i] = intervals.get(i)[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> res = new ArrayList<>();
        for (int endIndex = 0, startIndex = 0; endIndex < n; endIndex++) {
            if (endIndex == n - 1 || starts[endIndex + 1] > ends[endIndex]) {
                res.add(new int[]{starts[startIndex], ends[endIndex]});
                startIndex = endIndex + 1;
            }
        }
        return res;
    }

}
