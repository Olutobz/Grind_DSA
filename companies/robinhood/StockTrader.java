package robinhood;

import java.util.ArrayList;
import java.util.Arrays;
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

public class StockTrader {

    public static int execute(List<List<String>> orders) {
        PriorityQueue<Node> buyPQ = new PriorityQueue<>((a, b) -> b.price - a.price);
        PriorityQueue<Node> sellPQ = new PriorityQueue<>((a, b) -> a.price - b.price);

        int totalExecuted = 0;

        for (List<String> order : orders) {
            int price = Integer.parseInt(order.get(0));
            int quantity = Integer.parseInt(order.get(1));
            boolean isSell = order.get(2).equals("sell");

            Node curr = new Node(price, quantity);

            // SELL order
            if (isSell) {
                while (!buyPQ.isEmpty() && buyPQ.peek().price >= curr.price && curr.share > 0) {
                    Node buyNode = buyPQ.poll();
                    if (buyNode.share > curr.share) {
                        totalExecuted += curr.share;
                        buyNode.share -= curr.share;
                        buyPQ.offer(buyNode); // some shares remain
                        curr.share = 0;
                    } else {
                        totalExecuted += buyNode.share;
                        curr.share -= buyNode.share;
                    }
                }
                // Push the remaining shares to sell queue if any
                if (curr.share > 0) {
                    sellPQ.offer(curr);
                }
            }
            // BUY order
            else {
                while (!sellPQ.isEmpty() && sellPQ.peek().price <= curr.price && curr.share > 0) {
                    Node sellNode = sellPQ.poll();
                    if (sellNode.share > curr.share) {
                        totalExecuted += curr.share;
                        sellNode.share -= curr.share;
                        sellPQ.offer(sellNode);
                        curr.share = 0;
                    } else {
                        totalExecuted += sellNode.share;
                        curr.share -= sellNode.share;
                    }
                }
                if (curr.share > 0) {
                    buyPQ.offer(curr);
                }
            }
        }

        return totalExecuted;
    }

    //1. Maintain two PQs -
    // sellPQ which has all the pending sell orders in a minHeap
    // (because a buy order wants to be paired with the lowest priced pending sell order)
    // and a buyPQ which has all the pending buy orders in a maxHeap
    // (because a sell order wants to be paired with the highest priced pending buy order).

    //2. Process all the orders one at a time.
    //2a) If it is a SELL order:
    //i. Check if it can be executed or fulfilled by some pending buy order.
    //ii. If yes, execute the order by taking the min(shares needed to fulfill the current order, shares that can be fulfuilled by the topmost pending buy order)
    //iii. Add the remainder shares to the corresponding PQs for future orders.

    //2b) If it is a BUY order: Repeat the similar steps.
    //Repeat the process 2 for all the orders.

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList("150", "5", "buy"));
        orders.add(Arrays.asList("190", "1", "sell"));
        orders.add(Arrays.asList("200", "1", "sell"));
        orders.add(Arrays.asList("100", "9", "buy"));
        orders.add(Arrays.asList("140", "8", "sell"));
        orders.add(Arrays.asList("210", "4", "buy"));

        System.out.println(execute(orders));
    }

    static class Node {
        int price;
        int share;

        public Node(int p, int s) {
            price = p;
            share = s;
        }
    }
}