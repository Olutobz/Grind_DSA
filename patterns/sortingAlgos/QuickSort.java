package sortingAlgos;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 09, July 2025
 * EMAIL: damexxey94@gmail.com
 */


public class QuickSort {

    // TC -> O(n^2), SC -> O(n)
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] > pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }

        if (arr[leftPointer] > pivot) {
            swap(arr, leftPointer, highIndex);
        } else leftPointer = highIndex;

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
