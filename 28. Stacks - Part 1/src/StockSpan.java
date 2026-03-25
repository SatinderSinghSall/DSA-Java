// Stack-Problem: Stock Span Problem.

import java.util.*;

public class StockSpan {
    public static int[] calculateSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // First day span is always 1
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            // Pop elements smaller than current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, span = i + 1
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 85, 100};
        int[] result = calculateSpan(price);

        System.out.println(Arrays.toString(result));
    }
}
