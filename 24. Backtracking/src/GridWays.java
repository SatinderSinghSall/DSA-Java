// Grid Ways Algorithm:

public class GridWays {
    public static void printGridWays(int n, int m) {
        int[][] dp = new int[n][m];

        // Base case: destination cell
        dp[n - 1][m - 1] = 1;

        // Fill DP table from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // Skip destination (already set)
                if (i == n - 1 && j == m - 1) continue;

                int down = (i + 1 < n) ? dp[i + 1][j] : 0;
                int right = (j + 1 < m) ? dp[i][j + 1] : 0;

                dp[i][j] = down + right;
            }
        }

        // Print grid
        System.out.println("\nGrid showing number of ways from each cell:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nTotal number of ways: " + dp[0][0]);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        printGridWays(n, m);
    }
}
