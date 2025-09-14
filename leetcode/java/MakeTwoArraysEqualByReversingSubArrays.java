package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 04, August 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays of equal length target and arr.
 * In one step, you can select any non-empty subarray of arr and reverse it.
 * You are allowed to make any number of steps.
 * Return true if you can make arr equal to target or false otherwise.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse subarray [4,2], arr becomes [1,2,4,3]
 * 3- Reverse subarray [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 *
 * Example 2:
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 *
 * Example 3:
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr does not have value 9 and it can never be converted to target.
 * </pre>
 * </blockquote>
 */


public class MakeTwoArraysEqualByReversingSubArrays {

    // TC -> O(N), SC -> O(1001) [Using leetcode constraints]
    private boolean canBeEqual(int[] target, int[] arr) {
        int[] freqCounterArr = new int[1001];

        for (int i = 0; i < target.length; i++) {
            freqCounterArr[target[i]]++;
            freqCounterArr[arr[i]]--;
        }

        for (int count : freqCounterArr) {
            if (count != 0) return false;
        }

        return true;
    }

    // TC -> O(N), SC -> O(N)
    private boolean canBeEqualII(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
        }

        for (int currKey : map.keySet()) {
            if (map.get(currKey) != 0) {
                return false;
            }
        }

        return true;
    }

    // TC -> O(NLogN), SC -> O(1)
    private boolean canBeEqualIII(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }

    // TC -> O(N^2), SC -> O(1)
    private boolean canBeEqualIV(int[] target, int[] arr) {
        int count = 0;
        for (int currTarget : target) {
            for (int currValue : arr) {
                if (currTarget == currValue) {
                    count++;
                }
            }
        }

        return count == target.length;
    }

}
