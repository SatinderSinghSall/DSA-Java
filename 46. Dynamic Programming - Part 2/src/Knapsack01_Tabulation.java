// Dynamic Programming: 0/1 Knapsack Problem using Tabulation.

// Time Complexity: O(nxW) & Space Complexity: O(nxW)

public class Knapsack01_Tabulation {

    public static int knapsack(int val[], int wt[], int W) {

        int n = val.length;

        // DP Table
        int dp[][] = new int[n + 1][W + 1];

        // Bottom-Up
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                // Current item's value and weight
                int v = val[i - 1];
                int w = wt[i - 1];

                // Valid case
                if (w <= j) {

                    int includeProfit = v + dp[i - 1][j - w];
                    int excludeProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(includeProfit, excludeProfit);

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};

        int W = 7;

        System.out.println("Maximum Profit = "
                + knapsack(val, wt, W));
    }
}
