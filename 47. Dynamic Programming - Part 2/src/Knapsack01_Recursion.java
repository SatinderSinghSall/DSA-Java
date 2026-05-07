// Dynamic Programming: O/1 Knapsack Problem using Recursion.

// Time Complexity: 2^n

public class Knapsack01_Recursion {
    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return  0;
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);

            // exclude
            int ans2 = knapsack(val, wt, W, n - 1);

            return Math.max(ans, ans2);
        } else { // not valid
            return knapsack(val, wt, W, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Dynamic Programming: O/1 Knapsack Problem using Recursion.");

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = val.length;

        System.out.println(knapsack(val, wt, W, n));
    }
}
