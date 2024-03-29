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
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        // TC -> O(N), SC -> O(1)
        // Pushes element x to the top of the stack
        // Pushes element x to the top of the stack
        public void push(int x) {
            while (!q1.isEmpty()) {
                q2.offer(q1.remove());
            }
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.remove());
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
        // Removes the element on the top of the stack and returns it
        public int pop() {
            return q1.remove();
        }

        // TC -> O(1), SC -> O(1)
        // Returns the element on the top of the stack
        public int top() {
            return q1.peek();
        }

        // TC -> O(1), SC -> O(1)
        // Returns whether the stack is empty
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    static class MyStackII {
        Queue<Integer> queue;

        public MyStackII() {
            queue = new LinkedList<>();
        }

        // TC -> O(N), SC -> O(1)
        // Pushes element x to the top of the stack
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        // TC -> O(1), SC -> O(1)
        // Removes the element on the top of the stack and returns it
        public int pop() {
            return queue.remove();
        }

        // TC -> O(1), SC -> O(1)
        // Returns the element on the top of the stack
        public int top() {
            return queue.peek();
        }

        // TC -> O(1), SC -> O(1)
        // Returns whether the stack is empty
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
