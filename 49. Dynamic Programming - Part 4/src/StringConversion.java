// Dynamic Programming: String Conversion.

// Convert String1 to String2 using
// only insertion and deletion operations.


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

public class StringConversion {

    // 1. RECURSION:

    public static int stringConversionRec(String s1, String s2,
                                          int i, int j) {

        // base cases
        if (i == s1.length()) {
            return s2.length() - j; // insert remaining
        }

        if (j == s2.length()) {
            return s1.length() - i; // delete remaining
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return stringConversionRec(
                    s1, s2,
                    i + 1, j + 1
            );
        }

        // insert
        int insert = 1 + stringConversionRec(
                s1, s2,
                i, j + 1
        );

        // delete
        int delete = 1 + stringConversionRec(
                s1, s2,
                i + 1, j
        );

        return Math.min(insert, delete);
    }


    // 2. MEMOIZATION:

    public static int stringConversionMemo(String s1, String s2,
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
                    stringConversionMemo(
                            s1, s2,
                            i + 1, j + 1,
                            dp
                    );
        }

        // insert
        int insert = 1 + stringConversionMemo(
                s1, s2,
                i, j + 1,
                dp
        );

        // delete
        int delete = 1 + stringConversionMemo(
                s1, s2,
                i + 1, j,
                dp
        );

        dp[i][j] = Math.min(insert, delete);

        return dp[i][j];
    }


    // 3. TABULATION:

    public static int stringConversionTab(String s1, String s2) {

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

                    dp[i][j] = Math.min(insert, delete);
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

        String str1 = "pear";
        String str2 = "sea";

        // Recursion
        int recAns = stringConversionRec(
                str1, str2,
                0, 0
        );

        // Memoization
        int[][] dp = new int[str1.length()][str2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = stringConversionMemo(
                str1, str2,
                0, 0,
                dp
        );

        // Tabulation
        int tabAns = stringConversionTab(str1, str2);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
