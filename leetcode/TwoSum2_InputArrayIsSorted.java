import java.util.HashMap;
import java.util.Map;

public class TwoSum2_InputArrayIsSorted {

    // TC -> O(N), SC -> O(1)
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{};
    }

    // TC -> O(N), SC -> O(N)
    public int[] twoSum2I(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }

        return new int[]{};
    }

    // TC -> O(NLogN), SC -> O(1)
    public int[] twoSum2II(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[i] + numbers[mid] == target && mid != i) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return new int[]{};
    }

    // TC -> O(N^2), SC -> O(1)
    public int[] twoSum2III(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[0];
    }

}
