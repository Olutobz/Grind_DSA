package basic_math;

import java.util.Arrays;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 06, July 2024
 * EMAIL: damexxey94@gmail.com
 */

public class ReverseArray {
    private static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("Reversed array: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // TC -> O(n), SC -> O(1)
    private static void reverseII(int[] arr) {
        swap(arr, 0, arr.length - 1);
        printArray(arr);
    }

    // TC -> O(n), SC -> O(n)
    private static void reverse(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[len - i - 1] = arr[i];
        }
        printArray(result);
    }

    // TC -> O(n), SC -> O(n)
    private static void reverseIII(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseIII(arr, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        int[] sample1 = {1, 2, 3, 4, 5};
        int[] sample2 = Arrays.copyOf(sample1, sample1.length);
        int[] sample3 = Arrays.copyOf(sample2, sample2.length);
        System.out.println("Original array: " + Arrays.toString(sample1));
        reverse(sample1);
        reverseII(sample2);
        reverseIII(sample3, 0, sample3.length - 1);
        printArray(sample3);
    }

}
