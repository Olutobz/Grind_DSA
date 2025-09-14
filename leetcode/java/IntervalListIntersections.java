package java;

import java.util.*;

public class IntervalListIntersections {

    // TC -> O(N + M), SC -> O(1) {if we ignore the output space}
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        if (firstList == null || firstList.length == 0
                || secondList == null || secondList.length == 0) {
            return res.toArray(new int[0][0]);
        }

        int m = firstList.length;
        int n = secondList.length;
        int i = 0, j = 0;

        while (i < m && j < n) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            int startMax = Math.max(a[0], b[0]);
            int endMin = Math.min(a[1], b[1]);
            if (endMin >= startMax) {
                res.add(new int[]{startMax, endMin});
            }
            if (a[1] == endMin) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
