package arrays;

import java.util.*;

public class Arrays101 {

    public int countDigits(Long digits) {
        int count = 0;
        while (digits != 0) {
            digits = digits / 10;
            count++;
        }
        return count;

        /* O(1)
        return (int) Math.floor(Math.log10(digits) + 1);
        */
    }

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

    // To check if there exists two integers N and M such that N is the double of M
    public boolean checkIfExist(int[] arr) {
        if (arr == null) return false;
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr.length; m++) {
                if (arr[n] == arr[m] * 2 && n != m) return true;
            }
        }
        return false;
    }

    public boolean checkIfExistFaster(int[] arr) {
        Set<Integer> comp = new HashSet<>();
        for (int num : arr) {
            if (comp.contains(num * 2) || (num % 2 == 0 && comp.contains(num / 2))) {
                return true;
            }
            comp.add(num);
        }
        return false;
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int count = 1;

        Arrays.sort(nums);
        if (length < 3) return nums[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) count++;
            if (count == 3) return nums[i];
        }

        return nums[length - 1];
    }

    @SuppressWarnings("DuplicatedCode")
    private int thirdMax2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (set.contains(num)) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            set.add(num);
        }

        if (set.size() >= 3) return max3;
        else return max1;
    }

}
