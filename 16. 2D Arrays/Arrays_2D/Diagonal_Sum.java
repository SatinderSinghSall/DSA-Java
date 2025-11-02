// Diagonal Sum:

package Arrays_2D;

public class Diagonal_Sum {

    // Method 1: Basic O(n^2) approach
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal
            if (i != n - 1 - i) { // Avoid double-counting the middle element
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("\nMatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int result = diagonalSum(matrix);
        System.out.println("\nDiagonal Sum: " + result);
    }
}
