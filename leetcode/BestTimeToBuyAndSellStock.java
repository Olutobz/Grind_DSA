public class BestTimeToBuyAndSellStock {

    // TC -> O(N), SC -> O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }

    // TC -> O(N), SC -> O(1)
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
