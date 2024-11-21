package robinhood;

import java.util.PriorityQueue;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 13, November 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * You are given a 2D integer array orders, where each orders[i] = [price[i], amount[i], orderType[i]]denotes that
 * amount[i] orders have been placed of type orderType[i] at the price[i]. The orderType[i] is:
 * 0 if it is a batch of buy orders, or
 * 1 if it is a batch of sell orders.
 * Note that orders[i] represents a batch of amount[i] independent orders with the same price and order type.
 * All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.
 * <p>
 * There is a backlog that consists of orders that have not been executed.
 * The backlog is initially empty. When an order is placed, the following happens:
 * <p>
 * If the order is a buy order, you look at the sell order with the smallest price in the backlog.
 * If that sell order's price is smaller than or equal to the current buy order's price,
 * they will match and be executed, and that sell order will be removed from the backlog.
 * Else, the buy order is added to the backlog.
 * Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog.
 * If that buy order's price is larger than or equal to the current sell order's price,
 * they will match and be executed, and that buy order will be removed from the backlog.
 * Else, the sell order is added to the backlog.
 * Return the total amount of orders in the backlog after placing all the orders from the input.
 * Since this number can be large, return it modulo 10^9 + 7.
 */

public class NumberOfOrdersInTheBacklog {


    // If the order is a buy order, you look at the sell order with the smallest price in the backlog.
    //if the order is a sell order, you look at the buy order with the largest price in the backlog

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (int[] currOrder : orders) {
            if (currOrder[2] == 0) {
                while (!sell.isEmpty() && currOrder[0] >= sell.peek()[0]
                        && currOrder[1] >= sell.peek()[1]) {
                    currOrder[1] -= sell.peek()[1];
                    sell.poll();
                }

                if (!sell.isEmpty() && currOrder[0] >= sell.peek()[0] && currOrder[1] > 0) {
                    sell.peek()[1] -= currOrder[1];
                    currOrder[1] = 0;
                }

                if (currOrder[1] > 0) {
                    buy.offer(currOrder);
                }

            } else {
                while (!buy.isEmpty() && currOrder[0] <= buy.peek()[0]
                        && currOrder[1] >= buy.peek()[1]) {
                    currOrder[1] -= buy.peek()[1];
                    buy.poll();
                }

                if (!buy.isEmpty() && currOrder[0] <= buy.peek()[0] && currOrder[1] > 0) {
                    buy.peek()[1] -= currOrder[1];
                    currOrder[1] = 0;
                }

                if (currOrder[1] > 0) {
                    sell.offer(currOrder);
                }
            }
        }

        long res = 0;
        for (int[] o : sell) {
            res += o[1];
        }
        for (int[] o : buy) {
            res += o[1];
        }
        return (int) (res % 1000000007);
    }
}
