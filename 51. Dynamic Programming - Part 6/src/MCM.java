// Dynamic Programming: Matrix Chain Multiplication (MCM)

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation

// Time Complexity:

// Recursion  : Exponential
// Memoization: O(n^3)
// Tabulation : O(n^3)


// Space Complexity:

// Recursion  : O(n)      // recursion stack
// Memoization: O(n^2)
// Tabulation : O(n^2)

import java.util.Arrays;

public class MCM {

    // 1. RECURSION:

    public static int matrixChainRec(int arr[], int i, int j) {

        // base case
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // place parenthesis at different places
        // and calculate minimum cost
        for (int k = i; k < j; k++) {

            int cost1 = matrixChainRec(arr, i, k);

            int cost2 = matrixChainRec(arr, k + 1, j);

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            minCost = Math.min(minCost, finalCost);
        }

        return minCost;
    }

    // 2. MEMOIZATION:

    public static int matrixChainMemo(int arr[],
                                      int i,
                                      int j,
                                      int dp[][]) {

        // base case
        if (i == j) {
            return 0;
        }

        // answer already exists
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        // try all possible partitions
        for (int k = i; k < j; k++) {

            int cost1 = matrixChainMemo(arr, i, k, dp);

            int cost2 = matrixChainMemo(arr, k + 1, j, dp);

            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            minCost = Math.min(minCost, finalCost);
        }

        return dp[i][j] = minCost;
    }

    // 3. TABULATION:

    public static int matrixChainTab(int arr[]) {

        int n = arr.length;

        int dp[][] = new int[n][n];

        // initialization
        // dp[i][i] = 0 already by default

        // len = chain length
        for (int len = 2; len <= n - 1; len++) {

            for (int i = 1; i <= n - len; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // try every partition
                for (int k = i; k < j; k++) {

                    int cost1 = dp[i][k];

                    int cost2 = dp[k + 1][j];

                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    int finalCost = cost1 + cost2 + cost3;

                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 3};

        int n = arr.length;

        // Recursion
        int recAns = matrixChainRec(arr, 1, n - 1);

        // Memoization
        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = matrixChainMemo(arr, 1, n - 1, dp);

        // Tabulation
        int tabAns = matrixChainTab(arr);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
