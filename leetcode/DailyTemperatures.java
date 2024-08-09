/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 08, August 2024
 * EMAIL: damexxey94@gmail.com
 */


import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 *  Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * </pre>
 * </blockquote>
 */


public class DailyTemperatures {

    // TC -> O(N), SC -> O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        return answer;
    }

    // TC -> O(N), SC -> O(N)
    public int[] dailyTemperaturesII(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        int[] answer = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;

        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top];
                answer[index] = i - index;
                top--;
            }

            stack[++top] = i;
        }

        return answer;
    }

}
