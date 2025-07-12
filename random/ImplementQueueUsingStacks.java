import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * <blockquote>
 * <pre>
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * </pre>
 * </blockquote>
 */

public class ImplementQueueUsingStacks {
    static class MyQueue {
        private final Stack<Integer> input;
        private final Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        // TC -> O(1), SC -> O(1)
        public void push(int x) {
            input.push(x);
        }

        // TC -> O(1), SC -> O(1)
        public int pop() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        // TC -> O(1), SC -> O(1)
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        // TC -> O(1), SC -> O(1)
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
