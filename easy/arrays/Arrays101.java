package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arrays101 {

    // Given a binary array nums, return the maximum number of consecutive 1's in the array.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else if (num == 1) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

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

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    // Count Operations to Obtain Zero
    public int countOperations(int num1, int num2) {
        int steps = 0;
        if (num1 < 0 || num2 < 0) return 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            steps++;
        }
        return steps;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String currStr = "";
            if (i % 3 == 0) {
                currStr += "Fizz";
            }
            if (i % 5 == 0) {
                currStr += "Buzz";
            }
            if (currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }
            result.add(currStr);
        }
        return result;
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int[] newArr = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = newArr.length - 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        while (start <= end) {
            if (nums[start] > nums[end]) {
                newArr[index] = nums[start++];
            } else {
                newArr[index] = nums[end--];
            }
            index--;
        }
        // return an array of the squares of each number sorted in non-decreasing order.
        return newArr;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums2[n - 1] > nums1[m - 1]) {
                    nums1[i] = nums2[n - 1];
                    n--;
                } else {
                    nums1[i] = nums1[m - 1];
                    m--;
                }
            } else if (m > 0) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
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

    public int[] replaceElementsFast(int[] arr) {
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

    public int[] replaceElementsSlow(int[] arr) {
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

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null) return null;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

}

