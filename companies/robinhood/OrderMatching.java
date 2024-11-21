package robinhood;

import java.util.List;
import java.util.PriorityQueue;


/**
 * Given a stream of incoming "buy" and "sell" orders
 * (as lists of limit price, quantity, and side, like ["155", "3", "buy"]),
 * determine the total quantity (or number of "shares") executed.
 * A "buy" order can be executed if there is a corresponding "sell" order
 * with a price that is less than or equal to the price of the "buy" order.
 * Similarly, a "sell" order can be executed if there is a corresponding "buy"
 * order with a price that is greater than or equal to the price of the "sell" order.
 * It is possible that an order does not execute immediately if it isn't paired to a counterparty.
 * In that case, you should keep track of that order and execute it at a later time when a pairing order is found.
 * You should ensure that orders are filled immediately at the best possible price.
 * That is, an order should be executed when it is processed, if possible.
 * Further, "buy" orders should execute at the lowest possible price and "sell" orders
 * at the highest possible price at the time the order is handled.
 *
 * <p>
 * <blockquote>
 * <pre>
 * Note that orders can be partially executed.
 * --- Sample Input ---
 * orders = [
 *      ['150', '5', 'buy'], # Order A
 *      ['190', '1', 'sell'], # Order B
 *      ['200', '1', 'sell'], # Order C
 *      ['100', '9', 'buy'], # Order D
 *      ['140', '8', 'sell'], # Order E
 *      ['210', '4', 'buy'], # Order F
 *   ]
 *
 * Sample Output : 9
 * </pre>
 * </blockquote>
 */

public class OrderMatching {

    /*
    Explanation:

    Priority Queues: We maintain two priority queues,
    one for buy orders and one for the sell orders.

    Order Processing:
    For each order, we check if it can be immediately matched with an order in the opposite queue.

    If a match is found, we execute the trade, updating the quantities
    and potentially adding partially filled orders back to the queue.

    If no immediate match is found,
    the order is added to the appropriate queue for future matching.

    Total Executed:
     The totalExecuted variable keeps track of the total quantity of shares executed.
    * */

    public int executeOrders(List<List<String>> orders) {
        if (orders == null || orders.isEmpty()) {
            return 0;
        }

        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int totalExecuted = 0;

        for (List<String> order : orders) {
            int price = Integer.parseInt(order.get(0));
            int quantity = Integer.parseInt(order.get(1));
            String side = order.get(2);

            if (side.equals("buy")) {
                while (!sellOrders.isEmpty() && sellOrders.peek()[0] <= price && quantity > 0) {
                    int[] sellOrder = sellOrders.poll();
                    int minQuantity = Math.min(quantity, sellOrder[1]);
                    totalExecuted += minQuantity;
                    quantity -= minQuantity;
                    sellOrder[1] -= minQuantity;
                    if (sellOrder[1] > 0) {
                        sellOrders.offer(sellOrder);
                    }
                }
                if (quantity > 0) {
                    buyOrders.offer(new int[]{price, quantity});
                }
            } else { // sell order
                while (!buyOrders.isEmpty() && buyOrders.peek()[0] >= price && quantity > 0) {
                    int[] buyOrder = buyOrders.poll();
                    int minQuantity = Math.min(quantity, buyOrder[1]);
                    totalExecuted += minQuantity;
                    quantity -= minQuantity;
                    buyOrder[1] -= minQuantity;
                    if (buyOrder[1] > 0) {
                        buyOrders.offer(buyOrder);
                    }
                }
                if (quantity > 0) {
                    sellOrders.offer(new int[]{price, quantity});
                }
            }
        }

        return totalExecuted;
    }
}