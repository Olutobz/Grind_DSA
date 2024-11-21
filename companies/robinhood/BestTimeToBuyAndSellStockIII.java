package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later,
 * as you are engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 * </pre>
 * </blockquote>
 */

public class BestTimeToBuyAndSellStockIII {

    /*
    First assume that we have no money, so buy1 means that we have to borrow money from others,
    we want to borrow less so that we have to make our balance as max,
    as we can (because this is negative).

    sell1 means we decide to sell the stock, after selling it we have price[i] money,
    and we have to give back the money we owed,
    so we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.

    buy2 means we want to buy another stock, we already have sell1 money,
    so after buying stock2 we have buy2 = sell1 - price[i] money left,
    we want more money left, so we make it max

    sell2 means we want to sell stock2, we can have price[i] money after selling it,
    and we have buy2 money left before, so sell2 = buy2 + prices[i], we make this max.

    So sell2 is the most money we can have.

    * */

    // TC -> O(N), SC -> O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int sell1 = 0;
        int sell2 = 0;
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
