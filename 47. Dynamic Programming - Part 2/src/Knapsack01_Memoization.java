// Dynamic Programming: 0/1 Knapsack Problem using Memoization.

// Time Complexity: O(n*W)

import java.util.Arrays;

public class Knapsack01_Memoization {

    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {

        // Base Case
        if (W == 0 || n == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // Valid Case
        if (wt[n - 1] <= W) {

            // Include
            int ans1 = val[n - 1]
                    + knapsack(val, wt, W - wt[n - 1], n - 1, dp);

            // Exclude
            int ans2 = knapsack(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);

        } else {

            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};

        int W = 7;
        int n = val.length;

        int dp[][] = new int[n + 1][W + 1];

        // Initialize with -1
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Maximum Profit = "
                + knapsack(val, wt, W, n, dp));
    }
}
