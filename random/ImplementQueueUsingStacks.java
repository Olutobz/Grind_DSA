import java.util.Stack;

public class ImplementQueueUsingStacks {
    static class MyQueue {

        Stack<Integer> stack;
        Stack<Integer> tstack;

        public MyQueue() {
            stack = new Stack<>();
            tstack = new Stack<>();
        }

        // TC -> O(1), SC -> O(1)
        // Pushes element x to the back of the queue.
        public void push(int x) {
            stack.push(x);
        }

        // TC -> O(1), SC -> O(1)
        // Removes the element from in front of queue.
        public int pop() {
            if (tstack.isEmpty()) {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    tstack.push(x);
                }
            }
            return tstack.pop();
        }

        // TC -> O(1), SC -> O(1)
        // Get the front element.
        public int peek() {
            if (tstack.isEmpty()) {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    tstack.push(x);
                }
            }
            return tstack.peek();
        }

        // TC -> O(1), SC -> O(1)
        // Return whether the queue is empty.
        public boolean empty() {
            return stack.isEmpty() && tstack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
