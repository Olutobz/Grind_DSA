import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LuckyIntegerInAnArray {

    // TC -> O(N), SC -> O(N)
    public int findLucky(int[] arr) {
        int[] freqArr = new int[501];

        for (int num : arr) {
            freqArr[num]++;
        }

        for (int i = 500; i > 0; i--) {
            if (freqArr[i] == i) return i;
        }

        return -1;
    }

    // TC -> O(N), SC -> O(N)
    public int findLuckyII(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            if (key == value) max = Math.max(max, key);
        }

        return max;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int findLuckyIII(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans++;
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (arr[i] == ans) return ans;
                ans = 0;
            }
        }

        return -1;
    }

}
