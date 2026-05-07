// Dynamic Programming: Longest Common Subsequence (LCS) using Recursion.

// Time Complexity: O(2^(n + m)) & Space Complexity: O(n + m)

public class LCS_Recursion {

    // Using Recursion Approach:
    public static int recursion(String str1, String str2, int n, int m) {

        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }

        // If characters match
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {

            return 1 + recursion(str1, str2, n - 1, m - 1);
        }

        // If characters do not match
        else {

            int ans1 = recursion(str1, str2, n - 1, m);

            int ans2 = recursion(str1, str2, n, m - 1);

            return Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {

        System.out.println("Dynamic Programming: Longest Common Subsequence (LCS) using Recursion.");

        String str1 = "abcde";
        String str2 = "ace";

        int n = str1.length();
        int m = str2.length();

        int ans = recursion(str1, str2, n, m);

        System.out.println("LCS Length = " + ans);
    }
}
