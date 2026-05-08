// Dynamic Programming: Catalan Number

// Catalan Numbers Formula:
//
// C0 = 1
// C1 = 1
//
// Cn = C0 * C(n-1)
//    + C1 * C(n-2)
//    + C2 * C(n-3)
//    + ...
//    + C(n-1) * C0


// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation


// Time Complexity:

// Recursion  : Exponential
// Memoization: O(n^2)
// Tabulation : O(n^2)


// Space Complexity:

// Recursion  : O(n)
// Memoization: O(n)
// Tabulation : O(n)

import java.util.Arrays;

public class CatalanNumber {

    // ---------------------------------------------------
    // 1. RECURSION
    // ---------------------------------------------------

    public static int catalanRec(int n) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        // formula
        for (int i = 0; i < n; i++) {

            ans += catalanRec(i)
                    * catalanRec(n - i - 1);
        }

        return ans;
    }

    // ---------------------------------------------------
    // 2. MEMOIZATION
    // ---------------------------------------------------

    public static int catalanMemo(int n, int[] dp) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;

        // formula
        for (int i = 0; i < n; i++) {

            ans += catalanMemo(i, dp)
                    * catalanMemo(n - i - 1, dp);
        }

        dp[n] = ans;

        return dp[n];
    }

    // ---------------------------------------------------
    // 3. TABULATION
    // ---------------------------------------------------

    public static int catalanTab(int n) {

        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;

        if (n >= 1) {
            dp[1] = 1;
        }

        // filling dp array
        for (int i = 2; i <= n; i++) {

            dp[i] = 0;

            for (int j = 0; j < i; j++) {

                dp[i] += dp[j]
                        * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // ---------------------------------------------------
    // MAIN FUNCTION
    // ---------------------------------------------------

    public static void main(String[] args) {

        int n = 4;

        // Recursion
        int recAns = catalanRec(n);

        // Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int memoAns = catalanMemo(n, dp);

        // Tabulation
        int tabAns = catalanTab(n);

        System.out.println("Recursion Answer = " + recAns);

        System.out.println("Memoization Answer = " + memoAns);

        System.out.println("Tabulation Answer = " + tabAns);
    }
}
