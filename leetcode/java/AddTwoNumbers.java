package java;

public class AddTwoNumbers {

    // TC -> O(max(N,M)), SC -> O(max(N,M)) where N is length of l1 & M is length of l2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;

        }

        return dummy.next;
    }

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
