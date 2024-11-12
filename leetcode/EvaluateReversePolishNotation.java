import java.util.Stack;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 12, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * </pre>
 * </blockquote>
 */

public class EvaluateReversePolishNotation {

    // TC -> O(n), SC -> O(n)
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        int first, second;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }

    // TC -> O(n), SC -> O(n)
    public int evalRPNII(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        int[] stack = new int[tokens.length];
        int top = 0;

        for (String str : tokens) {
            char c = str.charAt(0);
            if (c == '+') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a + b;
            } else if (c == '-' && str.length() == 1) {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a - b;
            } else if (c == '*') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a * b;
            } else if (c == '/') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a / b;
            } else
                stack[top++] = Integer.parseInt(str);
        }

        return stack[0];
    }

}
