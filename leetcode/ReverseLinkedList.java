public class ReverseLinkedList {

    /* Definition for singly-linked list. */
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // TC -> O(N), SC -> O(1)
    // Iterative method
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    /* TC -> O(N), SC -> O(N)
       Recursive method
     */
    public ListNode reverseListII(ListNode head) {
        return reverseListHelper(head, null);
    }

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
        // base case
        if (head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);
    }

}
