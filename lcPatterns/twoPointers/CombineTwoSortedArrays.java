package twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 25, October 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given two sorted integer arrays arr1 and arr2,
 * return a new array that combines both of them and is also sorted.
 */

public class CombineTwoSortedArrays {

    public List<Integer> combine(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++;
            } else {
                result.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            result.add(arr2[j]);
            j++;
        }

        return result;
    }
}
