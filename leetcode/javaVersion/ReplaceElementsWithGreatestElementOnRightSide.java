package javaVersion;

public class ReplaceElementsWithGreatestElementOnRightSide {

    // TC -> O(N^2), SC -> O(1)
    public int[] replaceElements(int[] arr) {
        int n = arr.length, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(arr[j], max);
            }
            arr[i] = max;
            max = 0;
        }
        arr[n - 1] = -1;
        return arr;
    }

    // TC -> O(N), SC -> O(1)
    public int[] replaceElementsII(int[] arr) {
        int n = arr.length;
        int max = -1;
        int temp;
        for (int i = n - 1; i > -1; i--) {
            temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }

}
