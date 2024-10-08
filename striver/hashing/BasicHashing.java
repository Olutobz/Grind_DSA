package hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 10, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class BasicHashing {

    public static void main(String[] args) {
        int[] occurrences = new int[8];
        int[] arr = {1, 2, 1, 3, 2};

        for (int item : arr) {
            occurrences[item]++;
        }

        fetchHashArray(occurrences);
        setupBasicMapSample();
        simpleThreadSafeMap();
        simpleThreadSafeMapII();

    }

    private static void fetchHashArray(int[] freq) {
        System.out.print("Hash array: ");
        for (int item : freq) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void setupBasicMapSample() {
        Map<Integer, Integer> map = new HashMap<>();
        int[] occurrences = {1, 1, 6, 4, 4, 4, 5, 5, 7};

        for (int currVal : occurrences) {
            map.put(currVal, map.getOrDefault(currVal, 0) + 1);
        }

        System.out.print("\nMap values: ");
        for (int value : map.values()) {
            System.out.print(value + " ");
        }

        System.out.print("\nMap keys: ");
        for (int key : map.keySet()) {
            System.out.print(key + " ");
        }

        System.out.println("\nMap Key-Value pairs: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void simpleThreadSafeMap() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(100, "Android");
        hashtable.put(102, "Mobile");
        hashtable.put(107, "United States");
        hashtable.put(112, "New York");
        hashtable.put(120, "San Francisco");

        System.out.println("Hashtable: " + hashtable);
        for (int key : hashtable.keySet()) {
            System.out.println(Integer.hashCode(key) % 5 + " -> " + hashtable.get(key));
        }
    }

    private static void simpleThreadSafeMapII() {
        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(100, "Android");
        concurrentMap.put(102, "Mobile");
        concurrentMap.put(107, "United States");
        concurrentMap.put(112, "Kotlin");
        concurrentMap.put(120, "San Francisco");

        System.out.println("Concurrent Map: " + concurrentMap);
        for (int key : concurrentMap.keySet()) {
            System.out.println(Integer.hashCode(key) % 5 + " -> " + concurrentMap.get(key));
        }
    }
}
