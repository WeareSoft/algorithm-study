package hackerrank;

import java.util.Stack;

/**
 * Largest Rectangle
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangle {
    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int top;

        int i = 0;
        while (i < h.length) {
            if (stack.empty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                top = h[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, top);
            }
        }

        while (!stack.empty()) {
            top = h[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, top);
        }

        return maxArea;
    }
}
