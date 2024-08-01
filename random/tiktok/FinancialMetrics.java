package tiktok;

import java.util.List;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 02, August 2024
 * EMAIL: damexxey94@gmail.com
 */

public class FinancialMetrics {

    public static int maxLengthGoodSubarray(List<Integer> metrics, int limit) {
        int maxLength = -1;
        int start = 0;
        int n = metrics.size();

        for (int end = 0; end < n; end++) {
            int length = end - start + 1;

            if (metrics.get(end) > limit / (double) length) {
                maxLength = Math.max(maxLength, length);
            } else {
                start = end + 1;
            }
        }

        return maxLength;
    }
}
