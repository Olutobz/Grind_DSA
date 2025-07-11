package sortingAlgos;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 09, July 2025
 * EMAIL: damexxey94@gmail.com
 */


public class MergeSort {

    // TC -> O(nlogn), SC -> O(n)
    public void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        System.arraycopy(arr, 0, leftArr, 0, mid);
        System.arraycopy(arr, mid, rightArr, 0, arr.length - mid);

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private void merge(int[] array, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            array[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            array[k++] = rightArr[j++];
        }
    }

}
