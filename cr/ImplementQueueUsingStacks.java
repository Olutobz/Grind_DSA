import java.util.Stack;

public class ImplementQueueUsingStacks {
    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // Pushes element x to the back of the queue.
        public void push(int x) {
            while (!s2.isEmpty())
                s1.push(s2.pop());

            s1.push(x);
        }

        // Removes the element from in front of queue.
        public int pop() {
            while (!s1.isEmpty())
                s2.push(s1.pop());

            return s2.pop();
        }

        // Get the front element.
        public int peek() {
            while (!s1.isEmpty())
                s2.push(s1.pop());

            return s2.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
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
