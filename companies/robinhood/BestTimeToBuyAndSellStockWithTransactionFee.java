package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * <p>
 * Note:
 * You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * Example 2:
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 *
 * Constraints:
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 * </pre>
 * </blockquote>
 */

public class BestTimeToBuyAndSellStockWithTransactionFee {

    /*
    * Intuition
    The intuition behind the solution is to keep track of the minimum cost to buy a stock at each day
    * and the maximum profit that can be achieved by selling the stock at each day.

    Approach:
    Initialize two variables: buy and sell. Set buy to negative infinity and sell to zero.
    * These variables will keep track of the maximum profit at each day.

    Iterate through the prices of the stocks starting from the first day.

    Update the buy variable by taking the maximum of its current value
    * and the previous sell value minus the stock price.
    * This represents the maximum profit after buying the stock.
    buy = max(buy, sell - price)

    Update the sell variable by taking the maximum of its current value
    * and the previous buy value plus the stock price minus the transaction fee.
    * This represents the maximum profit after selling the stock.
    sell = max(sell, buy + price - fee)

    After iterating through all the prices, the maximum profit will be stored in the sell variable.

    Return the value of sell as the maximum profit.

    */

    // TC -> O(n), SC -> O(1)
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }

    /*
     * At given day, we can do 1 out of 4 things:
    1. buy stock
    2. hold stock
    3. do nothing with empty portfolio (rest)
    4. sell stock
    *
    We have 4 arrays with the length of # of the days,
    recording the max profit at given day if we do the given operation.
     * */

    // TC -> O(n), SC -> O(n)
    public int maxProfitII(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int[] buy = new int[len];
        int[] hold = new int[len];
        int[] skip = new int[len];
        int[] sell = new int[len];

        // the moment we buy a stock, our balance should decrease
        buy[0] = -prices[0]; // 0 - prices[0]

        // assume if we have stock in the first day, we are still in deficit
        hold[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // We can only buy on today if we sold stock
            // or skipped with empty portfolio yesterday
            buy[i] = Math.max(skip[i - 1], sell[i - 1]) - prices[i];

            // Can only hold if we bought or already holding stock yesterday
            hold[i] = Math.max(buy[i - 1], hold[i - 1]);

            // Can skip only if we skipped, or sold stock yesterday
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);

            // Can sell only if we bought, or held stock yesterday
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee;
        }

        // Get the max of all the 4 actions on the last day.
        int max = Math.max(buy[len - 1], hold[len - 1]);
        max = Math.max(skip[len - 1], max);
        max = Math.max(sell[len - 1], max);

        return Math.max(max, 0);
    }
}
