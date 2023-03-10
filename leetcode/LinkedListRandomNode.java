import java.util.Random;

public class LinkedListRandomNode {
    ListNode head;
    Random rand;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        ListNode curr = head;
        int count = 0;
        int res = 0;

        while (curr != null) {
            int r = rand.nextInt(count + 1);
            if (r == count) {
                res = curr.val;
            }
            count++;
            curr = curr.next;
        }

        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
