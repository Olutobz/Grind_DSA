package arraysNstrings;

import java.util.*;

public class ArraysAndStrings {

    // TC -> O(N), SC -> O(N)
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        leftSum[0] = nums[0];
        rightSum[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[length - 1 - i] = rightSum[length - i] + nums[length - 1 - i];
        }
        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }
        return -1;
    }

    // TC -> O(N) SC -> O(1)
    public int pivotIndexII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, leftSum = 0;

        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == sum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int maxElem = Integer.MIN_VALUE, maxIndex = -1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElem) {
                maxElem = nums[i];
                maxIndex = i;
            }
        }
        for (int num : nums) {
            if (maxElem >= num * 2) count++;
        }
        if (count == nums.length - 1) return maxIndex;

        return -1;
    }

    public int dominantIndexII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int max1 = 0, max2 = 0, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 >= max2 * 2) ? maxIndex : -1;
    }

    // TC -> O(N), SC -> O(1)
    @SuppressWarnings("DuplicatedCode")
    private int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

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
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    // TC -> O(NlogN), SC -> O(1)
    public int maximumProductII(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    // TC -> O(N), SC -> O(N)
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int k = 0; k < length; k++) {
            answer[k] = left[k] * right[k];
        }
        return answer;

    }

    // TC -> O(N), SC -> O(N)
    public int[] productExceptSelfII(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];

        for (int i = 0, temp = 1; i < length; i++) {
            left[i] = temp;
            temp *= nums[i];
        }
        for (int i = length - 1, temp = 1; i >= 0; i--) {
            left[i] *= temp;
            temp *= nums[i];
        }
        return left;
    }

    // TC -> O(N), SC -> O(N)
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[0];
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    // TC -> O(N), SC -> O(1)
    public void reverseString(char[] s) {
        int first = 0, last = s.length - 1;
        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }

    // TC -> O(M*N), SC -> O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        if (cols == 0) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    // TC -> O(M + N), SC -> O(1)
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = cols - 1;

        while (start < rows && end >= 0) {
            if (matrix[start][end] == target) return true;
            else if (matrix[start][end] > target) end--;
            else start++;
        }
        return false;
    }

    // TC -> O(LogM + LogN) -> O(Log(M*N)), SC -> O(1)
    public boolean searchMatrixIII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;

        while (start <= end) {
            int pivotIndex = start + (end - start) / 2;
            // formulae => a[x] : matrix[x / m][x % m] where m -> column of the matrix
            int pivotElem = matrix[pivotIndex / cols][pivotIndex % cols];
            if (target == pivotElem) return true;
            else if (target < pivotElem) end = pivotIndex - 1;
            else start = pivotIndex + 1;
        }
        return false;
    }

    // TC -> O(sqrt(x)), SC -> O(1)
    public int mySqrt(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x / i; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1))
                return i;
        }
        return -1;
    }

    // TC -> O(log x), SC -> O(1)
    public int mySqrtII(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if (mid > x / mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    // TC -> O(log(num)), SC -> O(1)
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // TC -> O(log(num)), SC -> O(1)
    public boolean isPerfectSquareII(int num) {
        if (num == 0 || num == 1) return true;
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == num / mid && num % mid == 0) return true;
            else if (mid < num / mid) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    // TC -> O(c), SC -> O(1)
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }

    // TC -> O(sqrt(clog c)), SC -> O(1)
    public boolean judgeSquareSumII(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    // TC -> O(sqrt(clog c)), SC -> O(1)
    public boolean judgeSquareSumIII(int c) {
        if (c < 3) return true;
        long a = 0, b = (int) Math.sqrt(c);

        while (a <= b) {
            long sum = (a * a) + (b * b);
            if (sum == c) return true;
            else if (sum < c) a++;
            else b--;
        }
        return false;
    }

    // TC -> O(sqrt c), SC -> O(N)
    public boolean judgeSquareSumIV(int c) {
        Set<Integer> set = new HashSet<>();

        for (int a = 0; a <= Math.sqrt(c); a++) {
            set.add(a * a);
            if (set.contains(c - a * a)) return true;
        }
        return false;
    }

    // TC -> O(M * N), M = number of rows, N = number of columns.
    // SC -> O(1), (if we ignore the returned array)
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int row = 0, col = 0;
        int[] result = new int[m * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];
            // even sum diagonal -> go up
            if ((row + col) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else {
                    row--;
                    col++;
                }
            }
            // odd sum diagonal -> go down
            else if ((row + col) % 2 == 1) {
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else {
                    row++;
                    col--;
                }
            }

        }

        return result;
    }

    // TC -> O(M * N), SC -> O(N)
    public int[] findDiagonalOrderII(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int indexSum = i + j;
                if (!diagonalMap.containsKey(indexSum)) {
                    diagonalMap.put(indexSum, new ArrayList<>());
                }

                if (indexSum % 2 == 0) diagonalMap.get(indexSum).add(0, mat[i][j]);
                else diagonalMap.get(indexSum).add(mat[i][j]);
            }
        }

        int index = 0;
        int[] result = new int[mat.length * mat[0].length];
        for (int indexSum : diagonalMap.keySet()) {
            for (int val : diagonalMap.get(indexSum)) {
                result[index++] = val;
            }
        }

        return result;
    }

}
