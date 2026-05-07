// Dynamic Programming: Coin Change Problem.

import java.util.Arrays;

public class CoinChange {

    // ---------------------------------------------------
    // RECURSION
    // ---------------------------------------------------
    public static int recursion(int[] coins, int n, int sum) {

        // Base Cases
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        // Include current coin
        int include = 0;

        if (coins[n - 1] <= sum) {
            include = recursion(coins, n, sum - coins[n - 1]);
        }

        // Exclude current coin
        int exclude = recursion(coins, n - 1, sum);

        return include + exclude;
    }

    // ---------------------------------------------------
    // MEMOIZATION
    // ---------------------------------------------------
    public static int memoization(int[] coins, int n, int sum, int[][] dp) {

        // Base Cases
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        int include = 0;

        // Include coin
        if (coins[n - 1] <= sum) {
            include = memoization(coins, n, sum - coins[n - 1], dp);
        }

        // Exclude coin
        int exclude = memoization(coins, n - 1, sum, dp);

        dp[n][sum] = include + exclude;

        return dp[n][sum];
    }

    // ---------------------------------------------------
    // TABULATION
    // ---------------------------------------------------
    public static int tabulation(int[] coins, int sum) {

        int n = coins.length;

        int[][] dp = new int[n + 1][sum + 1];

        // sum = 0 => 1 way
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= sum; j++) {

                // Exclude
                dp[i][j] = dp[i - 1][j];

                // Include
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    // ---------------------------------------------------
    // MAIN
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] coins = {1, 2, 3};
        int sum = 4;

        int n = coins.length;

        // Recursion
        int recAns = recursion(coins, n, sum);
        System.out.println("Recursion Answer = " + recAns);

        // Memoization
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = memoization(coins, n, sum, dp);
        System.out.println("Memoization Answer = " + memoAns);

        // Tabulation
        int tabAns = tabulation(coins, sum);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
