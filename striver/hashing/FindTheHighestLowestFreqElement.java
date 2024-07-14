package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 14, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class FindTheHighestLowestFreqElement {

    public static void main(String[] args) {
        int[] arr = {10, 5, 10, 15, 10, 5};
        countHighestLowestFreq(arr);
        countHighestLowestFreqII(arr);
    }

    // TC -> O(n^2), SC -> O(n)
    private static void countHighestLowestFreq(int[] arr) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        int maxElement = 0, maxFreq = 0;
        int minElement = 0, minFreq = len;

        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            else visited[i] = true;
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            if (count > maxFreq) {
                maxFreq = count;
                maxElement = arr[i];
            } else if (count < minFreq) {
                minFreq = count;
                minElement = arr[i];
            }
        }

        System.out.println("The highest frequency element is " + maxElement + " with a freq count of " + maxFreq);
        System.out.println("The lowest frequency element is " + minElement + " with a freq count of " + minFreq);
    }

    // TC -> O(n), SC -> O(n)
    private static void countHighestLowestFreqII(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxElement = 0, maxFreq = 0;
        int minElement = 0, minFreq = arr.length;

        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxElement = element;
            } else if (count < minFreq) {
                minFreq = count;
                minElement = element;
            }
        }

        System.out.println("The highest frequency element is " + maxElement + " with a freq count of " + maxFreq);
        System.out.println("The lowest frequency element is " + minElement + " with a freq count of " + minFreq);
    }
}
