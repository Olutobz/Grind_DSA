package java;

import java.util.Arrays;

public class MaximumIceCreamBars {

    // TC -> O(NLogN), SC -> O(1)
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int answer = 0;
        while (answer < n && costs[answer] <= coins) {
            coins -= costs[answer];
            answer += 1;
        }
        return answer;
    }
}
