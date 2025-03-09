package javaVersion;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    // TC -> O(NLogN), SC -> O(N)
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEnd = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start < prevEnd) {
                count++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;

    }

    // TC -> O(NLogN), SC -> O(N)
    public int eraseOverlapIntervalsII(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // sort based on start values of the intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prevEnd = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;

    }

}
