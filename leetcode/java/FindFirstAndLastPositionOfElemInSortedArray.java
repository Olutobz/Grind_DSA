package java;

public class FindFirstAndLastPositionOfElemInSortedArray {
    // TC -> O(LogN), SC -> O(N)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] arr, int target) {
        int start = 0, end = arr.length - 1, first = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }
            if (arr[mid] == target) first = mid;
        }
        return first;
    }

    private int findLast(int[] arr, int target) {
        int start = 0, end = arr.length - 1, last = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else  {
                end = mid - 1;
            }
            if (arr[mid] == target) last = mid;
        }
        return last;
    }
}
