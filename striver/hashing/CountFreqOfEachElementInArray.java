package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class CountFreqOfEachElementInArray {

    public static void main(String[] args) {
        int[] arr = {10, 5, 10, 15, 10, 5};
        countFreq(arr);
        countFreqII(arr);
    }

    // TC -> O(n^2), SC -> O(n)
    private static void countFreq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        boolean[] visited = new boolean[arr.length];
        System.out.println("Using boolean array: ");

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            else visited[i] = true;
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " -> " + count);
        }
        System.out.println(Arrays.toString(visited));
    }

    // TC -> O(n), SC -> O(n)
    private static void countFreqII(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Using HashMap: ");
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
