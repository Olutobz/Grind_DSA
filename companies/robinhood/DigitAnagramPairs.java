package robinhood;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers a, the task was to count the no of pairs i, j ,
 * such that a[i] and a[j] are digit anagrams.
 *
 * <blockquote>
 * <pre>
 * input = [321, 213, 123, 456, 654, 789]
 * output = 4
 * </pre>
 * </blockquote>
 */

public class DigitAnagramPairs {

    // TC -> O(n * k log k), SC -> O(n)
    public static int countDigitAnagramPairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        int pairCount = 0;

        for (int num : arr) {
            char[] digits = Integer.toString(num).toCharArray();
            Arrays.sort(digits);
            String sortedForm = String.valueOf(digits);

            int count = frequencyMap.getOrDefault(sortedForm, 0);
            pairCount += count;

            frequencyMap.put(sortedForm, count + 1);
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int[] a = {321, 213, 123, 456, 654, 789};
        System.out.println(countDigitAnagramPairs(a));
    }
}