import java.util.*;

public class MaxHistogramArea {

    public static int maxArea(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n]; // next smaller right
        int[] nsl = new int[n]; // next smaller left

        Stack<Integer> s = new Stack<>();

        // NSR
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // clear stack
        s = new Stack<>();

        // NSL
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // area calculation
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(arr));
    }
}
