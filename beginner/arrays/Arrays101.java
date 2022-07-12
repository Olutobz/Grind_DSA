package arrays;

import java.util.ArrayList;
import java.util.List;

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

    private int countDigits(Long digits) {
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
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i+1] = 0;
                i++;
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
        if(num1 < 0 || num2 < 0) return 0;
        while(num1 != 0 && num2 != 0) {
            if(num1 >= num2) {
                num1 -= num2;
            }
            else {
                num2 -= num1;
            }
            steps++;
        }
        return steps;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            String currStr = "";
            if (i%3 == 0) {
                currStr += "Fizz";
            }
            if(i%5 == 0) {
                currStr += "Buzz";
            }
            if(currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }
            result.add(currStr);
        }
        return result;
    }

    public int[] sortedSquares(int[] nums) {
        int[] newArr = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int index = newArr.length-1;

        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }

        while(start <= end) {
            if(nums[start] > nums[end]) {
                newArr[index] = nums[start];
                start++;
            } else {
                newArr[index] = nums[end];
                end--;
            }
            index--;
        }

        // return an array of the squares of each number sorted in non-decreasing order.
        return newArr;
    }

}
