// Dynamic Programming: Edit Distance.

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation


// Time Complexity:

// Recursion  : Exponential -> O(3^(n + m))
// Memoization: O(n * m)
// Tabulation : O(n * m)


// Space Complexity:

// Recursion  : O(n + m)   // recursion stack
// Memoization: O(n * m)
// Tabulation : O(n * m)



import java.util.Arrays;

public class EditDistance {

    // 1. RECURSION:

    public static int editDistanceRec(String s1, String s2,
                                      int i, int j) {

        // base cases
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return editDistanceRec(s1, s2, i + 1, j + 1);
        }

        // insert
        int insert = 1 + editDistanceRec(s1, s2, i, j + 1);

        // delete
        int delete = 1 + editDistanceRec(s1, s2, i + 1, j);

        // replace
        int replace = 1 + editDistanceRec(s1, s2, i + 1, j + 1);

        return Math.min(insert,
                Math.min(delete, replace));
    }


    // 2. MEMOIZATION:

    public static int editDistanceMemo(String s1, String s2,
                                       int i, int j,
                                       int[][] dp) {

        // base cases
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        // already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j] =
                    editDistanceMemo(s1, s2,
                            i + 1, j + 1, dp);
        }

        // insert
        int insert = 1 + editDistanceMemo(
                s1, s2, i, j + 1, dp
        );

        // delete
        int delete = 1 + editDistanceMemo(
                s1, s2, i + 1, j, dp
        );

        // replace
        int replace = 1 + editDistanceMemo(
                s1, s2, i + 1, j + 1, dp
        );

        dp[i][j] = Math.min(insert,
                Math.min(delete, replace));

        return dp[i][j];
    }


    // 3. TABULATION:

    public static int editDistanceTab(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }

        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j;
        }

        // bottom-up filling
        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                // characters match
                if (s1.charAt(i) == s2.charAt(j)) {

                    dp[i][j] = dp[i + 1][j + 1];

                } else {

                    int insert = 1 + dp[i][j + 1];

                    int delete = 1 + dp[i + 1][j];

                    int replace = 1 + dp[i + 1][j + 1];

                    dp[i][j] = Math.min(insert,
                            Math.min(delete, replace));
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

        String word1 = "intention";
        String word2 = "execution";

        // Recursion
        int recAns = editDistanceRec(word1, word2, 0, 0);

        // Memoization
        int[][] dp = new int[word1.length()][word2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = editDistanceMemo(
                word1, word2,
                0, 0, dp
        );

        // Tabulation
        int tabAns = editDistanceTab(word1, word2);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
