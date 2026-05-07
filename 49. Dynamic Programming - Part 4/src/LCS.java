// Dynamic Programming: Longest Common Substring.

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation

// Time Complexity:

// Recursion  : Exponential -> O(2^(n + m))
// Memoization: O(n * m)
// Tabulation : O(n * m)


// Space Complexity:

// Recursion  : O(n + m)   // recursion stack
// Memoization: O(n * m)
// Tabulation : O(n * m)

import java.util.Arrays;

public class LCS {

    // 1. RECURSION:

    static int recursionAns = 0;

    public static int longestCommonSubstringRec(String s1, String s2,
                                                int n, int m, int count) {

        // base case
        if (n == 0 || m == 0) {
            return count;
        }

        // characters match
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {

            count = longestCommonSubstringRec(
                    s1, s2,
                    n - 1,
                    m - 1,
                    count + 1
            );
        }

        // move in both directions
        recursionAns = Math.max(
                count,
                Math.max(
                        longestCommonSubstringRec(s1, s2, n - 1, m, 0),
                        longestCommonSubstringRec(s1, s2, n, m - 1, 0)
                )
        );

        return recursionAns;
    }

    // 2. MEMOIZATION:

    public static int longestCommonSubstringMemo(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    ans = Math.max(ans, dp[i][j]);

                } else {

                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    // 3. TABULATION:

    public static int longestCommonSubstringTab(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // characters match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    ans = Math.max(ans, dp[i][j]);

                } else {

                    // reset because substring must be contiguous
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s1 = "ABCDE";
        String s2 = "ABGCE";

        // Recursion
        recursionAns = 0;
        int recAns = longestCommonSubstringRec(
                s1,
                s2,
                s1.length(),
                s2.length(),
                0
        );

        // Memoization
        int memoAns = longestCommonSubstringMemo(s1, s2);

        // Tabulation
        int tabAns = longestCommonSubstringTab(s1, s2);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
