// Tiling Problem:

/*
 == Problem Statement: ==
 * Given a 2 × n board and tiles of size 2 × 1, find the total number of
 * ways to completely fill the board using these tiles. Each tile can be
 * placed either horizontally i.e., as a 1 x 2 tile or vertically i.e.,
 * as 2 x 1 tile.
*/

public class TilingProblem {
    public static int Tiling_Problem_Logic(int n) { // 2 x n (floor size)
        if (n == 0 || n == 1) {
            return 1;
        }

        // vertical choice:
        int fnm1 = Tiling_Problem_Logic(n - 1);

        // horizontal choice:
        int fnm2 = Tiling_Problem_Logic(n - 2);

        int total_ways = fnm1 + fnm2;

        return total_ways;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Tiling_Problem_Logic(n));
    }
}
