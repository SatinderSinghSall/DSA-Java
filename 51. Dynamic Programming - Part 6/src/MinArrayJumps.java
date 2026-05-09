// Dynamic Programming: Minimum Array Jumps

// Problem:
// Given an array where each element represents
// maximum jump length from that position,
// find minimum jumps required to reach end.

// Methods Included:
// 1. Recursion
// 2. Memoization
// 3. Tabulation

// Time Complexity:

// Recursion  : Exponential
// Memoization: O(n^2)
// Tabulation : O(n^2)


// Space Complexity:

// Recursion  : O(n)      // recursion stack
// Memoization: O(n)
// Tabulation : O(n)

import java.util.Arrays;

public class MinArrayJumps {

    // 1. RECURSION:

    public static int minJumpsRec(int arr[], int idx) {

        int n = arr.length;

        // base case
        if (idx >= n - 1) {
            return 0;
        }

        // cannot move forward
        if (arr[idx] == 0) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;

        // try all possible jumps
        for (int jump = 1; jump <= arr[idx]; jump++) {

            int nextIdx = idx + jump;

            if (nextIdx < n) {

                int jumps = minJumpsRec(arr, nextIdx);

                if (jumps != Integer.MAX_VALUE) {

                    ans = Math.min(ans, jumps + 1);
                }
            }
        }

        return ans;
    }

    // 2. MEMOIZATION:

    public static int minJumpsMemo(int arr[],
                                   int idx,
                                   int dp[]) {

        int n = arr.length;

        // base case
        if (idx >= n - 1) {
            return 0;
        }

        // cannot move
        if (arr[idx] == 0) {
            return Integer.MAX_VALUE;
        }

        // answer already exists
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;

        // try every possible jump
        for (int jump = 1; jump <= arr[idx]; jump++) {

            int nextIdx = idx + jump;

            if (nextIdx < n) {

                int jumps = minJumpsMemo(arr, nextIdx, dp);

                if (jumps != Integer.MAX_VALUE) {

                    ans = Math.min(ans, jumps + 1);
                }
            }
        }

        return dp[idx] = ans;
    }

    // 3. TABULATION:

    public static int minJumpsTab(int arr[]) {

        int n = arr.length;

        int dp[] = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        // base case
        dp[n - 1] = 0;

        // move backwards
        for (int i = n - 2; i >= 0; i--) {

            int steps = arr[i];

            // check all reachable positions
            for (int j = i + 1;
                 j <= i + steps && j < n;
                 j++) {

                if (dp[j] != Integer.MAX_VALUE) {

                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 1, 1, 4};

        // Recursion
        int recAns = minJumpsRec(arr, 0);

        // Memoization
        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);

        int memoAns = minJumpsMemo(arr, 0, dp);

        // Tabulation
        int tabAns = minJumpsTab(arr);

        System.out.println("Recursion Answer = " + recAns);
        System.out.println("Memoization Answer = " + memoAns);
        System.out.println("Tabulation Answer = " + tabAns);
    }
}
