import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * <blockquote> <pre>
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * </pre></blockquote>
 */

public class ImplementQueueUsingStacks {
    static class MyQueue {
        private final Stack<Integer> stack;
        private final Stack<Integer> tstack;

        public MyQueue() {
            stack = new Stack<>();
            tstack = new Stack<>();
        }

        // TC -> O(1), SC -> O(1)
        public void push(int x) {
            stack.push(x);
        }

        // TC -> O(1), SC -> O(1)
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
        public boolean empty() {
            return stack.isEmpty() && tstack.isEmpty();
        }
    }
}
