// Dynamic Programming: Unbounded Knapsack using Tabulation.

// Time Complexity: O(n×W) & Space Complexity: O(n×W)

public class UnboundedKnapsack {

    public static int unboundedKnapsack(int val[], int wt[], int W) {

        int n = val.length;

        // DP Table
        int dp[][] = new int[n + 1][W + 1];

        // Bottom-Up
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                // Valid
                if (w <= j) {

                    // Include current item again
                    int includeProfit = v + dp[i][j - w];

                    // Exclude
                    int excludeProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(includeProfit, excludeProfit);

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Print DP Table
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};

        int W = 7;

        System.out.println("\nMaximum Profit = "
                + unboundedKnapsack(val, wt, W));
    }
}
