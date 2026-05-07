// Dynamic Programming: Longest Common Subsequence (LCS) using Memoization.

import java.util.Arrays;

// Time Complexity: O(n * m) & Space Complexity: O(n * m)

public class LCS_Memoization {

    // Using Memoization Approach:
    public static int memoization(String str1, String str2,
                                  int n, int m, int[][] dp) {

        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // If characters match
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {

            dp[n][m] = 1 + memoization(str1, str2,
                    n - 1, m - 1, dp);
        }

        // If characters do not match
        else {

            int ans1 = memoization(str1, str2,
                    n - 1, m, dp);

            int ans2 = memoization(str1, str2,
                    n, m - 1, dp);

            dp[n][m] = Math.max(ans1, ans2);
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        System.out.println("Dynamic Programming: Longest Common Subsequence (LCS) using Memoization.");

        String str1 = "abcde";
        String str2 = "ace";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = memoization(str1, str2, n, m, dp);

        System.out.println("LCS Length = " + ans);
    }
}
