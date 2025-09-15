package java;

public class ValidMountainArray {

    // TC -> O(N), SC -> O(1)
    public boolean validMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start != end) {
            if (arr[start] < arr[start + 1]) {
                start++;
            } else if (arr[end] < arr[end - 1]) {
                end--;
            } else {
                return false;
            }
        }
        return start != 0 && end != arr.length - 1;
    }

    // TC -> O(N), SC -> O(1)
    public boolean validMountainArray2(int[] arr) {
        if (arr.length < 3) return false;
        int n = arr.length, start = 0, end = n - 1;

        // walk up
        while (start + 1 < n && arr[start] < arr[start + 1]) {
            start++;
        }
        // peak cannot be first or last
        if (start == 0 || start == end) {
            return false;
        }
        // walk down
        while (start + 1 < n && arr[start] > arr[start + 1]) {
            start++;
        }
        // walked back to the ground
        return start == end;
    }

    // TC -> O(N), SC -> O(1)
    public boolean validMountainArray3(int[] arr) {
        if (arr.length < 3) return false;
        int n = arr.length, i = 0, j = n - 1;

        // walk up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        // walk down
        while (j - 1 < n && arr[j] < arr[j - 1]) {
            j--;
        }
        return i > 0 && j < n - 1 && i == j;
    }

}
