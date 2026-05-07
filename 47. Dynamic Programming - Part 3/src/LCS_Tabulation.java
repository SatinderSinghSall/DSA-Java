// Dynamic Programming: Longest Common Subsequence (LCS) using Tabulation.

// Time Complexity: O(n * m) & Space Complexity: O(n * m)

public class LCS_Tabulation {

    // Using Tabulation Approach:
    public static int tabulation(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // If characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // If characters do not match
                else {

                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        System.out.println("Dynamic Programming: Longest Common Subsequence (LCS) using Tabulation.");

        String str1 = "abcde";
        String str2 = "ace";

        int ans = tabulation(str1, str2);

        System.out.println("LCS Length = " + ans);
    }
}
