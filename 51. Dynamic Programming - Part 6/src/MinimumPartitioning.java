// Dynamic Programming: Minimum Partitioning

// Problem:
// Divide array into 2 subsets such that
// difference of their sums is minimum.

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation

// Time Complexity:

// Recursion  : O(2^n)
// Memoization: O(n * sum)
// Tabulation : O(n * sum)


// Space Complexity:

// Recursion  : O(n)         // recursion stack
// Memoization: O(n * sum)
// Tabulation : O(n * sum)

import java.util.Arrays;

public class MinimumPartitioning {

    // 1. RECURSION:

    public static int minimumPartitionRec(int arr[],
                                          int n,
                                          int sum1,
                                          int totalSum) {

        // base case
        if (n == 0) {

            int sum2 = totalSum - sum1;

            return Math.abs(sum1 - sum2);
        }

        // include current element in subset 1
        int include = minimumPartitionRec(
                arr,
                n - 1,
                sum1 + arr[n - 1],
                totalSum
        );

        // exclude current element from subset 1
        int exclude = minimumPartitionRec(
                arr,
                n - 1,
                sum1,
                totalSum
        );

        return Math.min(include, exclude);
    }

    // 2. MEMOIZATION:

    public static int minimumPartitionMemo(int arr[],
                                           int n,
                                           int sum1,
                                           int totalSum,
                                           int dp[][]) {

        // base case
        if (n == 0) {

            int sum2 = totalSum - sum1;

            return Math.abs(sum1 - sum2);
        }

        // answer already exists
        if (dp[n][sum1] != -1) {
            return dp[n][sum1];
        }

        // include current element
        int include = minimumPartitionMemo(
                arr,
                n - 1,
                sum1 + arr[n - 1],
                totalSum,
                dp
        );

        // exclude current element
        int exclude = minimumPartitionMemo(
                arr,
                n - 1,
                sum1,
                totalSum,
                dp
        );

        return dp[n][sum1] = Math.min(include, exclude);
    }

    // 3. TABULATION:

    public static int minimumPartitionTab(int arr[]) {

        int n = arr.length;

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int W = totalSum / 2;

        boolean dp[][] = new boolean[n + 1][W + 1];

        // initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // subset sum logic
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                int val = arr[i - 1];

                // include
                if (val <= j && dp[i - 1][j - val]) {

                    dp[i][j] = true;

                } else if (dp[i - 1][j]) {

                    // exclude
                    dp[i][j] = true;
                }
            }
        }

        int sum1 = 0;

        // find closest possible sum to totalSum/2
        for (int j = W; j >= 0; j--) {

            if (dp[n][j]) {

                sum1 = j;
                break;
            }
        }

        int sum2 = totalSum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {

        int arr[] = {1, 6, 11, 5};

        int n = arr.length;

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        // Recursion
        int recAns = minimumPartitionRec(
                arr,
                n,
                0,
                totalSum
        );

        // Memoization
        int dp[][] = new int[n + 1][totalSum + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = minimumPartitionMemo(
                arr,
                n,
                0,
                totalSum,
                dp
        );

        // Tabulation
        int tabAns = minimumPartitionTab(arr);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
