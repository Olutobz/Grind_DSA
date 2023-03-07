import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    // TC -> O(N), SC -> O(1)
    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0; // F(n-2)
        int b = 1; // F(n-1)
        int sum = 0;
        while (n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }

    // TC -> O(N), SC -> O(N)
    public int fibII(int n) {
        if (n <= 1) return n;

        int[] map = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }

        return map[n];
    }

    // TC -> O(2^N), SC -> O(N)
    public int fibIII(int n) {
        if (n <= 1) return n;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return getFibFromMap(n, map);

    }

    // TC -> O(2^n), SC -> O(1)
    private int getFibFromMap(int n, HashMap<Integer, Integer> map) {
        if (!map.containsKey(n)) {
            int currenFib = getFibFromMap(n - 1, map) + getFibFromMap(n - 2, map);
            map.put(n, currenFib);
        }
        return map.get(n);
    }


}
