import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 05, August 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * A distinct string is a string that is present only once in an array.
 * <p>
 * Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
 * If there are fewer than k distinct strings, return an empty string "".
 * <p>
 * Note that the strings are considered in the order in which they appear in the array.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: arr = ["d","b","c","b","c","a"], k = 2
 * Output: "a"
 * Explanation:
 * The only distinct strings in arr are "d" and "a".
 * "d" appears 1st, so it is the 1st distinct string.
 * "a" appears 2nd, so it is the 2nd distinct string.
 * Since k == 2, "a" is returned.
 *
 * Example 2:
 * Input: arr = ["aaa","aa","a"], k = 1
 * Output: "aaa"
 * Explanation:
 * All strings in arr are distinct, so the 1st string "aaa" is returned.
 *
 * Example 3:
 * Input: arr = ["a","b","a"], k = 3
 * Output: ""
 * Explanation:
 * The only distinct string is "b".
 * Since there are fewer than 3 distinct strings, we return an empty string "".
 *  </pre>
 * </blockquote>
 */

public class KthDistinctStringInAnArray {

    // TC -> O(N), SC -> O(N)
    private String kthDistinct(String[] arr, int k) {
        if (arr == null || arr.length == 0) return "";

        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }

        return "";
    }


    // TC -> O(N), SC -> O(N)
    private String kthDistinctII(String[] arr, int k) {
        if (arr == null || arr.length == 0)
            return "";

        int count = 0;
        Map<String, Integer> orderedMap = new LinkedHashMap<>();

        for (String str : arr) {
            orderedMap.put(str, orderedMap.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : orderedMap.entrySet()) {
            if (orderedMap.get(entry.getKey()) == 1) {
                count++;
                if (count == k) {
                    return entry.getKey();
                }
            }
        }

        return "";
    }


    // TC -> O(N^2), SC -> O(1)
    private String kthDistinctIII(String[] arr, int k) {
        if (arr == null || arr.length == 0) return "";

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isDistinct(arr, i)) {
                count++;
                if (count == k) {
                    return arr[i];
                }
            }
        }

        return "";
    }

    private boolean isDistinct(String[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(arr[index]) && i != index) {
                return false;
            }
        }
        return true;
    }
}
