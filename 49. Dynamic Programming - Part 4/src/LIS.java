// Dynamic Programming: Longest Increasing Subsequence (LIS).

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation


// Time Complexity:

// Recursion  : Exponential -> O(2^n)
// Memoization: O(n * n)
// Tabulation : O(n * n)


// Space Complexity:

// Recursion  : O(n)       // recursion stack
// Memoization: O(n * n)
// Tabulation : O(n)



import java.util.Arrays;

public class LIS {

    // 1. RECURSION:

    public static int lisRec(int[] arr, int curr, int prev) {

        // base case
        if (curr == arr.length) {
            return 0;
        }

        // exclude
        int exclude = lisRec(arr, curr + 1, prev);

        // include
        int include = 0;

        if (prev == -1 || arr[curr] > arr[prev]) {

            include = 1 + lisRec(arr, curr + 1, curr);
        }

        return Math.max(include, exclude);
    }


    // 2. MEMOIZATION:

    public static int lisMemo(int[] arr, int curr, int prev, int[][] dp) {

        // base case
        if (curr == arr.length) {
            return 0;
        }

        // already calculated
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        // exclude
        int exclude = lisMemo(arr, curr + 1, prev, dp);

        // include
        int include = 0;

        if (prev == -1 || arr[curr] > arr[prev]) {

            include = 1 + lisMemo(arr, curr + 1, curr, dp);
        }

        dp[curr][prev + 1] = Math.max(include, exclude);

        return dp[curr][prev + 1];
    }


    // 3. TABULATION:

    public static int lisTab(int[] arr) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] arr = {50, 3, 10, 7, 40, 80};

        // Recursion
        int recAns = lisRec(arr, 0, -1);

        // Memoization
        int[][] dp = new int[arr.length][arr.length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int memoAns = lisMemo(arr, 0, -1, dp);

        // Tabulation
        int tabAns = lisTab(arr);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
