package javaVersion;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    // TC -> O(N^2), SC -> O(N)
    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slope;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // overlap
                if (x1 == x2) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = (y2 - y1) / ((double) (x2 - x1));
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                res = Math.max(res, map.get(slope));
            }
        }
        return res + 1;
    }
}
