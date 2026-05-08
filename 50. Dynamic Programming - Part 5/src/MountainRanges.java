// Dynamic Programming: Mountain Ranges

// Problem:
// Find number of valid mountain ranges
// using n pairs of up-strokes and down-strokes.


// Condition:
//
// At any moment,
// number of down-strokes
// cannot be more than up-strokes.


// NOTE:
// Mountain Ranges also follows
// Catalan Number pattern.


// Formula:
//
// MR(n) = MR(0) * MR(n-1)
//       + MR(1) * MR(n-2)
//       + MR(2) * MR(n-3)
//       + ...
//       + MR(n-1) * MR(0)


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

public class MountainRanges {

    // ---------------------------------------------------
    // 1. RECURSION
    // ---------------------------------------------------

    public static int mountainRangesRec(int n) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        // formula
        for (int i = 0; i < n; i++) {

            int inside = mountainRangesRec(i);

            int outside = mountainRangesRec(
                    n - i - 1
            );

            ans += inside * outside;
        }

        return ans;
    }

    // ---------------------------------------------------
    // 2. MEMOIZATION
    // ---------------------------------------------------

    public static int mountainRangesMemo(int n,
                                         int[] dp) {

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

            int inside = mountainRangesMemo(
                    i,
                    dp
            );

            int outside = mountainRangesMemo(
                    n - i - 1,
                    dp
            );

            ans += inside * outside;
        }

        dp[n] = ans;

        return dp[n];
    }

    // ---------------------------------------------------
    // 3. TABULATION
    // ---------------------------------------------------

    public static int mountainRangesTab(int n) {

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

                int inside = dp[j];

                int outside = dp[i - j - 1];

                dp[i] += inside * outside;
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
        int recAns = mountainRangesRec(n);

        // Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int memoAns = mountainRangesMemo(n, dp);

        // Tabulation
        int tabAns = mountainRangesTab(n);

        System.out.println("Recursion Answer = " + recAns);

        System.out.println("Memoization Answer = " + memoAns);

        System.out.println("Tabulation Answer = " + tabAns);
    }
}
