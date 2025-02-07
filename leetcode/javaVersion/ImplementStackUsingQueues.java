package javaVersion;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class ImplementStackUsingQueues {

    static class MyStack {
        Queue<Integer> queue;
        Queue<Integer> tempQueue;

        public MyStack() {
            queue = new LinkedList<>();
            tempQueue = new LinkedList<>();
        }

        // TC -> O(n), SC -> O(1)
        public void push(int x) {
            while (!queue.isEmpty()) {
                tempQueue.offer(queue.remove());
            }

            queue.offer(x);
            while (!tempQueue.isEmpty()) {
                queue.offer(tempQueue.remove());
            }

        /* Follow-up: Can you implement the stack using only one queue?
           q1.offer(x);
           int n = q1.size();
           while (n > 1) {
               q1.offer(q1.remove());
               n--;
           }

        */
        }

        // TC -> O(1), SC -> O(1)
        public int pop() {
            return queue.remove();
        }

        // TC -> O(1), SC -> O(1)
        public int top() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.peek();
        }

        // TC -> O(1), SC -> O(1)
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    static class MyStackII {
        Queue<Integer> queue;

        public MyStackII() {
            queue = new LinkedList<>();
        }

        // TC -> O(n), SC -> O(1)
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        // TC -> O(1), SC -> O(1)
        public int pop() {
            return queue.remove();
        }

        // TC -> O(1), SC -> O(1)
        public int top() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.peek();
        }

        // TC -> O(1), SC -> O(1)
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
