package javaVersion;

public class DuplicateZeros {

    // TC -> O(N^2), SC -> O(1)
    public void duplicateZeros(int[] arr) {
        if (arr.length == 0) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 0) {
                int j = n - 1;
                while (j > i) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    // TC -> O(N), SC -> O(1)
    public void duplicateZerosFaster(int[] arr) {
        int countZero = 0;
        for (int a : arr) {
            if (a == 0) countZero++;
        }
        int n = arr.length + countZero;
        for (int i = arr.length - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i];
            }
        }
    }
}
