package hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 10, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class BasicHashing {

    public static void main(String[] args) {
        int[] hashArray = new int[8];
        int[] arr = {1, 2, 1, 3, 2};

        for (int item : arr) {
            hashArray[item] += 1;
        }

        fetchHashArray(hashArray);
        simpleHashTableTest();

        Map<Integer, Integer> map = new HashMap<>();
        int[] arrOfInt = {1, 1, 6, 4, 4, 4, 5, 5, 7};

        for (int item : arrOfInt) {
            map.put(item, map.getOrDefault(item, 0) + 1);
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

    private static void fetchHashArray(int[] arr) {
        System.out.print("Hash array: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void simpleHashTableTest() {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(100, "Android");
        table.put(102, "Mobile");
        table.put(107, "United States");
        table.put(112, "New York");
        table.put(120, "San Francisco");
        System.out.println();
        for (int key : table.keySet()) {
            System.out.println(Integer.hashCode(key) % 5 + "\t" + table.get(key));
        }

    }
}