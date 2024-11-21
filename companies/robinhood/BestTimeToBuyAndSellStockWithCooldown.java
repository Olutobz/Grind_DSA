package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Example 2:
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * </pre>
 * </blockquote>
 */

public class BestTimeToBuyAndSellStockWithCooldown {

    /* INTUITION:

    On any i-th day, we can buy, sell or cooldown
    buy[i]: The maximum profit can be made if the first i days end with buy or wait.
    E.g "buy, sell, buy" or "buy, cooldown, cooldown"
    sell[i]: The maximum profit can be made if the first i days end with sell or wait.
    E.g "buy, sell, buy, sell" or "buy, sell, cooldown, cooldown"
    price: prices[i - 1], which is the stock price of the i-th day


    1. To calculate sell[i]:
    If we sell on the i-th day, the maximum profit is buy[i - 1] + price,
     because we have to buy before we can sell.
    If we cool down on the i-th day, the maximum profit is same as sell[i - 1]
     since we did not do anything on the i-th day.
    So sell[i] is the larger one of (buy[i - 1] + price, sell[i - 1])

    2. To calculate buy[i]:
    If we buy on the i-th day, the maximum profit is sell[i - 2] - price,
    because on the (i-1)th day we can only cool down.
    If we cool down on the i-th day, the maximum profit is same as buy[i - 1]
    since we did not do anything on the i-th day.
    So sell[i] is the larger one of (sell[i - 2] - price, buy[i - 1])

    * */

    // TC -> O(N), SC -> O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int length = prices.length;
        // buy[i]: max profit if the first "i" days end with a "buy" day
        int[] buy = new int[length + 1];
        // buy[i]: max profit if the first "i" days end with a "sell" day
        int[] sell = new int[length + 1];

        buy[1] = -prices[0];

        for (int i = 2; i <= length; i++) {
            int price = prices[i - 1];
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
        }

        // sell[length] >= buy[length]
        return sell[length];
    }


    // TC -> O(N), SC -> O(n)
    public int maxProfitII(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] sell = new int[len];
        int[] buy = new int[len];

        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[len - 1];
    }
}
