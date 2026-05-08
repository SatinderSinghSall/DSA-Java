// Dynamic Programming: Wildcard Matching

// Wildcard Characters:
// '?' -> Matches any single character
// '*' -> Matches any sequence of characters (including empty)

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation

// Time Complexity:

// Recursion  : Exponential
// Memoization: O(n * m)
// Tabulation : O(n * m)


// Space Complexity:

// Recursion  : O(n + m)   // recursion stack
// Memoization: O(n * m)
// Tabulation : O(n * m)

import java.util.Arrays;

public class WildcardMatching {

    // ---------------------------------------------------
    // 1. RECURSION
    // ---------------------------------------------------

    public static boolean wildcardMatchingRec(String s, String p,
                                              int n, int m) {

        // base case

        // both string & pattern finished
        if (n == 0 && m == 0) {
            return true;
        }

        // pattern finished but string left
        if (m == 0 && n > 0) {
            return false;
        }

        // string finished but pattern left
        if (n == 0 && m > 0) {

            // remaining pattern must contain only '*'
            for (int i = 0; i < m; i++) {

                if (p.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }

        // characters match OR '?'
        if (s.charAt(n - 1) == p.charAt(m - 1)
                || p.charAt(m - 1) == '?') {

            return wildcardMatchingRec(
                    s,
                    p,
                    n - 1,
                    m - 1
            );
        }

        // '*'
        else if (p.charAt(m - 1) == '*') {

            // 2 cases:
            // 1. ignore '*'
            // 2. match one character

            return wildcardMatchingRec(s, p, n, m - 1)
                    || wildcardMatchingRec(s, p, n - 1, m);
        }

        // not matched
        return false;
    }

    // ---------------------------------------------------
    // 2. MEMOIZATION
    // ---------------------------------------------------

    public static boolean wildcardMatchingMemo(String s, String p) {

        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];

        // -1 -> not visited
        // 0  -> false
        // 1  -> true

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helperMemo(s, p, n, m, dp);
    }

    public static boolean helperMemo(String s, String p,
                                     int n, int m,
                                     int[][] dp) {

        // base case

        if (n == 0 && m == 0) {
            return true;
        }

        if (m == 0 && n > 0) {
            return false;
        }

        if (n == 0 && m > 0) {

            for (int i = 0; i < m; i++) {

                if (p.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }

        // already calculated
        if (dp[n][m] != -1) {
            return dp[n][m] == 1;
        }

        boolean ans;

        // match OR '?'
        if (s.charAt(n - 1) == p.charAt(m - 1)
                || p.charAt(m - 1) == '?') {

            ans = helperMemo(
                    s,
                    p,
                    n - 1,
                    m - 1,
                    dp
            );
        }

        // '*'
        else if (p.charAt(m - 1) == '*') {

            ans = helperMemo(s, p, n, m - 1, dp)
                    || helperMemo(s, p, n - 1, m, dp);
        }

        // not matched
        else {

            ans = false;
        }

        dp[n][m] = ans ? 1 : 0;

        return ans;
    }

    // ---------------------------------------------------
    // 3. TABULATION
    // ---------------------------------------------------

    public static boolean wildcardMatchingTab(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case

        dp[0][0] = true;

        // string empty, pattern non-empty
        for (int j = 1; j <= m; j++) {

            boolean flag = true;

            for (int k = 1; k <= j; k++) {

                if (p.charAt(k - 1) != '*') {

                    flag = false;
                    break;
                }
            }

            dp[0][j] = flag;
        }

        // filling dp table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // characters match OR '?'
                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {

                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*'
                else if (p.charAt(j - 1) == '*') {

                    // ignore '*' OR match one char
                    dp[i][j] = dp[i][j - 1]
                            || dp[i - 1][j];
                }

                // not matched
                else {

                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // ---------------------------------------------------
    // MAIN FUNCTION
    // ---------------------------------------------------

    public static void main(String[] args) {

        String text = "baaabab";
        String pattern = "*****ba*****ab";

        // Recursion
        boolean recAns = wildcardMatchingRec(
                text,
                pattern,
                text.length(),
                pattern.length()
        );

        // Memoization
        boolean memoAns = wildcardMatchingMemo(
                text,
                pattern
        );

        // Tabulation
        boolean tabAns = wildcardMatchingTab(
                text,
                pattern
        );

        System.out.println("Recursion Answer = " + recAns);

        System.out.println("Memoization Answer = " + memoAns);

        System.out.println("Tabulation Answer = " + tabAns);
    }
}
