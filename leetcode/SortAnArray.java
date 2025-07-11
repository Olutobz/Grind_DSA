/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity
 * and with the smallest space complexity possible.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
 * while the positions of other numbers are changed (for example, 1 and 5).
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessarily unique.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * </pre>
 * </blockquote>
 */

public class SortAnArray {

    // TC -> O(nlogn), SC -> O(n)
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public void mergeSort(int[] arr) {
        if (arr.length < 2) return;

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
