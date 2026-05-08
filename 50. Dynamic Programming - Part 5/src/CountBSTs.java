// Dynamic Programming: Count BSTs

// Problem:
// Find number of all possible BSTs
// with given n nodes.


// Formula:
//
// BST(n) = BST(0) * BST(n-1)
//        + BST(1) * BST(n-2)
//        + BST(2) * BST(n-3)
//        + ...
//        + BST(n-1) * BST(0)


// NOTE:
// Count BSTs follows Catalan Number pattern.


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

public class CountBSTs {

    // ---------------------------------------------------
    // 1. RECURSION
    // ---------------------------------------------------

    public static int countBSTsRec(int n) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        // choosing each node as root
        for (int i = 0; i < n; i++) {

            int leftSubtree = countBSTsRec(i);

            int rightSubtree = countBSTsRec(n - i - 1);

            ans += leftSubtree * rightSubtree;
        }

        return ans;
    }

    // ---------------------------------------------------
    // 2. MEMOIZATION
    // ---------------------------------------------------

    public static int countBSTsMemo(int n, int[] dp) {

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;

        // choosing each node as root
        for (int i = 0; i < n; i++) {

            int leftSubtree = countBSTsMemo(i, dp);

            int rightSubtree = countBSTsMemo(
                    n - i - 1,
                    dp
            );

            ans += leftSubtree * rightSubtree;
        }

        dp[n] = ans;

        return dp[n];
    }

    // ---------------------------------------------------
    // 3. TABULATION
    // ---------------------------------------------------

    public static int countBSTsTab(int n) {

        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;

        if (n >= 1) {
            dp[1] = 1;
        }

        // filling dp array
        for (int i = 2; i <= n; i++) {

            dp[i] = 0;

            // choosing each node as root
            for (int j = 0; j < i; j++) {

                int leftSubtree = dp[j];

                int rightSubtree = dp[i - j - 1];

                dp[i] += leftSubtree * rightSubtree;
            }
        }

        return dp[n];
    }

    // ---------------------------------------------------
    // MAIN FUNCTION
    // ---------------------------------------------------

    public static void main(String[] args) {

        int n = 3;

        // Recursion
        int recAns = countBSTsRec(n);

        // Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int memoAns = countBSTsMemo(n, dp);

        // Tabulation
        int tabAns = countBSTsTab(n);

        System.out.println("Recursion Answer = " + recAns);

        System.out.println("Memoization Answer = " + memoAns);

        System.out.println("Tabulation Answer = " + tabAns);
    }
}
