import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycle {

    // TC -> O(N), SC -> O(N)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // TC -> O(N), SC -> O(N)
    public boolean hasCycleII(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }

        return false;
    }

    /**
     * Floyd’s Cycle-Finding Algorithm
     * Or
     * tortoise and the hare algorithm
     */
    // TC -> O(N), SC -> O(1)
    public boolean hasCycleIII(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
