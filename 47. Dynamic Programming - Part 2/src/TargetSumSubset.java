// Dynamic Programming: Target Sum Subset using Tabulation. (Variation of Knapsack Problem)

// Time Complexity: O(n×target) & Space Complexity: O(n×target)

public class TargetSumSubset {

    public static boolean targetSumSubset(int arr[], int target) {

        int n = arr.length;

        // DP Table
        boolean dp[][] = new boolean[n + 1][target + 1];

        // Initialization
        // Sum = 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Bottom-Up
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                int v = arr[i - 1];

                // Include possible
                if (v <= j) {

                    boolean include = dp[i - 1][j - v];
                    boolean exclude = dp[i - 1][j];

                    dp[i][j] = include || exclude;

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

        return dp[n][target];
    }

    public static void main(String[] args) {

        int arr[] = {4, 2, 7, 1, 3};

        int target = 10;

        System.out.println("\nTarget Exists = "
                + targetSumSubset(arr, target));
    }
}
