/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 15, August 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * At a lemonade stand, each lemonade costs $5.
 * Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * You must provide the correct change to each customer
 * so that the net transaction is that the customer pays $5.
 * <p>
 * Note that you do not have any change in hand at first.
 * <p>
 * Given an integer array bills where bills[i] is the bill the ith customer pays,
 * return true if you can provide every customer with the correct change, or false otherwise.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: bills = [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 *
 * Example 2:
 * Input: bills = [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can not give the change of $15 back because we only have two $10 bills.
 * Since not every customer received the correct change, the answer is false.
 *     </pre>
 * </blockquote>
 */
public class LemonadeChange {

    // TC -> O(N), SC -> O(1)
    private boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }

        int five_dollars = 0;
        int ten_dollars = 0;

        for (int currBill : bills) {
            if (currBill == 5) {
                five_dollars++;
            } else if (currBill == 10) {
                if (five_dollars == 0) {
                    return false;
                }
                five_dollars--;
                ten_dollars++;
            } else {
                if (five_dollars > 0 && ten_dollars > 0) {
                    five_dollars--;
                    ten_dollars--;
                } else if (five_dollars > 2) {
                    five_dollars -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // TC -> O(N), SC -> O(1)
    private boolean lemonadeChangeII(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }

        int five_dollars = 0;
        int ten_dollars = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five_dollars++;
            } else if (bill == 10) {
                five_dollars--;
                ten_dollars++;
            } else {
                if (ten_dollars > 0) {
                    ten_dollars--;
                    five_dollars--;
                } else {
                    five_dollars -= 3;
                }
            }
            if (five_dollars < 0) {
                return false;
            }
        }

        return true;
    }
}
