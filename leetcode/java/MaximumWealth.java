package java;

public class MaximumWealth {

    // TC -> O(M * N), SC -> O(1)
    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) return 0;
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int sum = 0;
            for (int bankMoney : customer) {
                sum += bankMoney;
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        /* for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }
        * */
        return maxWealth;
    }

}
