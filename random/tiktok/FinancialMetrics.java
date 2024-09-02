package tiktok;

import java.util.List;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 02, August 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an array financial metrics of size n, where each element represents a numerical financial metrics
 * and a threshold value limit, the goal is to find the maximum length of a non-empty consecutive sequence
 * of data points in the financial metrics that satisfies the following conditions:
 * <p>
 * Each Data point in the sequence must be greater than (limit/length of the sequence).
 * This sequence is term good sub array for analysis. If there is no good Subarray in the dataset, return -1
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
