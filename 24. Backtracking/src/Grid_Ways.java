// Grid Ways Algorithm:

public class Grid_Ways {

    public static int GridWays_Algorithm(int n, int m, int i, int j) {

        // base case: reached destination
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // base case: crossed boundary
        if (i >= n || j >= m) {
            return 0;
        }

        // recursive calls
        int down = GridWays_Algorithm(n, m, i + 1, j);
        int right = GridWays_Algorithm(n, m, i, j + 1);

        return down + right;
    }

    public static void main(String[] args) {
        System.out.println("\n\tGrid Ways Algorithm:");

        int n = 3, m = 3;
        int solution = GridWays_Algorithm(n, m, 0, 0);

        System.out.println("\nGrid Size: " + n + " x " + m);
        System.out.println("Total number of ways to reach destination: " + solution);
    }

}
