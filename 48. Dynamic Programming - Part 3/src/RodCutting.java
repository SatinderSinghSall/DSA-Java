// Dynamic Programming: Rod Cutting.

import java.util.Arrays;

public class RodCutting {
    // Using Recursion Approach:
    public static int recursion(int[] length, int[] price, int n, int rodLength) {

        // Base Case
        if (n == 0 || rodLength == 0) {
            return 0;
        }

        // Include
        int include = 0;

        if (length[n - 1] <= rodLength) {
            include = price[n - 1]
                    + recursion(length, price, n,
                    rodLength - length[n - 1]);
        }

        // Exclude
        int exclude = recursion(length, price, n - 1, rodLength);

        return Math.max(include, exclude);
    }

    // Using Memoization Approach:
    public static int memoization(int[] length, int[] price,
                                  int n, int rodLength, int[][] dp) {

        // Base Case
        if (n == 0 || rodLength == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n][rodLength] != -1) {
            return dp[n][rodLength];
        }

        int include = 0;

        // Include
        if (length[n - 1] <= rodLength) {
            include = price[n - 1]
                    + memoization(length, price, n,
                    rodLength - length[n - 1], dp);
        }

        // Exclude
        int exclude = memoization(length, price,
                n - 1, rodLength, dp);

        dp[n][rodLength] = Math.max(include, exclude);

        return dp[n][rodLength];
    }

    // Using Tabulation Approach:
    public static int tabulation(int[] length, int[] price, int rodLength) {

        int n = length.length;

        int[][] dp = new int[n + 1][rodLength + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= rodLength; j++) {

                // Exclude
                dp[i][j] = dp[i - 1][j];

                // Include
                if (length[i - 1] <= j) {

                    dp[i][j] = Math.max(
                            dp[i][j],
                            price[i - 1]
                                    + dp[i][j - length[i - 1]]
                    );
                }
            }
        }

        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        System.out.println("Dynamic Programming: Rod Cutting.");

        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        int rodLength = 8;

        int n = length.length;

        // Recursion
        int recAns = recursion(length, price, n, rodLength);
        System.out.println("Recursion Answer = " + recAns);

        // Memoization
        int[][] dp = new int[n + 1][rodLength + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = memoization(length, price,
                n, rodLength, dp);

        System.out.println("Memoization Answer = " + memoAns);

        // Tabulation
        int tabAns = tabulation(length, price, rodLength);

        System.out.println("Tabulation Answer = " + tabAns);
    }
}
