// Dynamic Programming: Climbing Stairs using Recursion.

// Time Complexity: 2^n

public class ClimbingStairs_Recursion {
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 1) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Dynamic Programming: Climbing Stairs using Recursion.");

        int n = 5;

        System.out.println(countWays(n));
    }
}
