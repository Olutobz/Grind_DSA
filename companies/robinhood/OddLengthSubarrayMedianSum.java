package robinhood;

import java.util.ArrayList;
import java.util.Collections;


/**
 * given an array of integers, find the sum of the medians of all odd-length subarrays of the array
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * arr = [1, 3, 2, 4]
 * output = 16
 * Explanations:
 * Subarrays of Odd Length:
 * Length 1: [1], [3], [2], [4] → Medians: 1, 3, 2, 4
 * Length 3: [1, 3, 2], [3, 2, 4] → Medians: 3, 3
 * Sum of Medians:
 * 1 + 3 + 2 + 4 + 3 + 3 = 16
 * </pre>
 * </blockquote>
 */

public class OddLengthSubarrayMedianSum {

    /*
    * Steps to Solve
    Definition of Odd-Length Subarray:
    Subarrays are parts of the array that are contiguous.
    Odd-length subarrays have lengths like 1, 3, 5, etc.
    *
    Median of a Subarray:
    For an odd-length array, the median is the middle element when the array is sorted.
    *
    Approach:
    Iterate over all possible subarray start and end indices.
    Check if the subarray length is odd.
    Extract the subarray, find its median, and add it to the running sum.*/

    public static void main(String[] args) {
        OddLengthSubarrayMedianSum solution = new OddLengthSubarrayMedianSum();
        int[] arr = {1, 3, 2, 4};
        System.out.println(solution.sumOfMedians(arr)); // Output the result
    }

    // TC -> O(n^3 log n), SC -> O(k)
    public int sumOfMedians(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int totalSum = 0;

        // Iterate over all possible subarray starting points
        for (int left = 0; left < arr.length; left++) {
            // Iterate over all possible subarray ending points
            for (int right = left; right < arr.length; right++) {
                // Calculate the windowLen of the subarray
                int windowLen = right - left + 1;

                // Check if the windowLen is odd
                if (windowLen % 2 == 1) {
                    // Extract the subarray
                    ArrayList<Integer> subarray = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        subarray.add(arr[i]);
                    }

                    // Find the median
                    Collections.sort(subarray);
                    int median = subarray.get(windowLen / 2);

                    // Add the median to the total sum
                    totalSum += median;
                }
            }
        }

        return totalSum;
    }
}
