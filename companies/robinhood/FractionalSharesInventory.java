package robinhood;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 21, November 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.*;

/**
 * On our journey to democratize finance for all, we’ve created the concept of fractional shares.
 * Fractional shares are pieces, or fractions, of whole shares of a company or ETF.
 * <p>
 * However, exchanges only trade in whole shares. Robinhood is required to manage the fractional portion of each trade.
 * <p>
 * If Robinhood has 0 shares of AAPL and then a customer wishes to purchase 1.5 AAPL shares,
 * Robinhood will need to request 2 shares from the exchange and hold on to the remaining 0.5 shares.
 * If another customer requests to purchase 0.4 shares of AAPL, Robinhood can use its inventory (0.5 shares)
 * instead of going out to the exchange and will have 0.1 shares of AAPL remaining.
 * If the third customer requests 0.5 shares, Robinhood can fill 0.1 shares out of inventory but will
 * need to go to the exchange for an additional share leaving Robinhood's inventory at 0.6 shares.
 *
 * If a customer requests a dollar based order, we need to convert it to the relevant number of shares
 * and run through the above steps.
 * Always ensure the firm has a positive quantity in inventory and has under one share after handling an order.
 * There's no need for us to hold onto whole shares!
 * Steps:
 * Handle buying fractional shares.
 * Handle selling fractional shares.
 * Ensure inventory is less than 1 after each order.
 * e.g. Customer sells AAPL for 0.75 and then another sells AAPL for 0.50 -- we have 1.25 inventory.
 * We can sell 1 share to the market and keep our inventory small at 0.25.
 * Ensure inventory is always non-negative after each order.
 * e.g. Inventory is 0.2 and the customer buys 0.5 shares: ensure we end up with 0.7 shares in inventory.
 * Always “flatten”! (steps 3+4)
 * The final 2 digits of every integer is the decimal. e.g. 1000 = 10.00, 20 = 0.20, 100 = 1.
 * <p>
 * <p>
 * Example scenario:
 * Input:
 * // One AAPL buy order for 0.42 shares. AAPL is currently worth $1.
 * orders: [["AAPL","B","42","100"]]
 * // Inventory for AAPL is currently 0.99 shares.
 * inventory: [["AAPL","99"]]
 * Expected Output:
 * // The users buys 0.42 shares from inventory, leaving us with 0.57 shares.
 * [["AAPL","57"]]
 * <p>
 * Another example scenario:
 * Input:
 * // One AAPL buy order for $0.42. AAPL is currently worth $1, so that's 0.42 shares.
 * orders: [["AAPL","B","$42","100"]]
 * // Existing AAPL inventory is 0.50 shares.
 * inventory: [["AAPL","50"]]
 * Expected Output:
 * // 0.50 - 0.42 = 0.08 shares leftover.
 * [["AAPL","8"]]
 * <p>
 * [input] array.array.string orders
 * <p>
 * A list of orders in the format of [$SYMBOL, $BUY_OR_SELL, $QUANTITY, $CURRENT_PRICE].
 * Each parameter is a string.
 * <p>
 * $SYMBOL: Can be "AAPL", "GOOGL", "MEOOOOOW" or anything really.
 * $BUY_OR_SELL: "B" or "S". B for BUY, S for SELL.
 * $QUANTITY: Can be a number or a dollar amount (prefixed with $). e.g. "100" for 1 quantity or "$150" for $1.50.
 * $CURRENT_PRICE: Current price of the symbol with no $ sign. e.g. "1000" for $10.
 * <p>
 * ** All numbers are multiplied by 100 to store two significant digits.
 * e.g. 100 = 1.00, 150 = 1.50, 1025 = 10.25 **
 * <p>
 * [input] array.array.string inventory
 * <p>
 * Inventory is a list of the inventory of each symbol.
 * Each element in the list a 2 item list of
 * [$SYMBOL, $QUANTITY] (remember quantity is multiplied by 100!).
 * <p>
 * An example for AAPL of 0.50 shares and GOOGL of 0.75 shares would be:
 * <p>
 * [["AAPL","50"],
 * ["GOOG","75"]]
 * [output] array.array.string
 * <p>
 * The output is the final inventory of each symbol after iterating through each trade.
 * This is expected to be in the same order and format as the inventory parameter.
 * <p>
 * e.g.
 * <p>
 * ["AAPL","58"],
 * ["GOOG","50"]
 */

public class FractionalSharesInventory {

    // 1: Store the current inventory for each symbol.
    /* 2: Process Orders
     * 2.1: Buy Order:
            Calculates the required shares by rounding up the division of quantity by price.
            Checks if the current inventory is sufficient.
            If not, purchases additional shares to fulfill the order and updates the inventory.

       2.2: Sell Order:
            Sells the required quantity from the inventory, ensuring it doesn't go negative.
     * */

    // 3: Return Updated Inventory:
    // Converts the inventoryMap to a list of lists in the required format.


    // TC -> O(n), SC -> O(n)
    public static List<List<String>> processOrders(List<List<String>> orders, List<List<String>> inventory) {

        Map<String, Integer> inventoryMap = new HashMap<>();
        for (List<String> item : inventory) {
            inventoryMap.put(item.get(0), Integer.parseInt(item.get(1)));
        }

        for (List<String> order : orders) {
            String symbol = order.get(0);
            String action = order.get(1);
            int quantity = Integer.parseInt(order.get(2));
            int price = Integer.parseInt(order.get(3));

            if (action.equals("B")) {
                int currentInventory = inventoryMap.getOrDefault(symbol, 0);
                int requiredShares = (quantity + price - 1) / price; // Round up
                int additionalShares = Math.max(requiredShares - currentInventory, 0);
                inventoryMap.put(symbol, currentInventory + additionalShares - quantity);
            } else if (action.equals("S")) {
                int currentInventory = inventoryMap.getOrDefault(symbol, 0);
                inventoryMap.put(symbol, Math.max(0, currentInventory - quantity));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inventoryMap.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), String.valueOf(entry.getValue())));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(processOrders(new ArrayList<>(), new ArrayList<>()));
    }

}
