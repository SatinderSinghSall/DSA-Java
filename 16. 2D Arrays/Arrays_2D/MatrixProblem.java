// Create a Java 2-D Matrix:

package Arrays_2D;

import java.util.Scanner;

public class MatrixProblem {
    public static void main(String[] args) {
        System.out.println("\nCreate a Java 2-D Matrix:");
        Scanner scanner = new Scanner(System.in);

        int matrix[][] = new int[3][3];
        int rows = matrix.length;
        int columns = matrix[0].length;

        // User Input:
        System.out.println("\nEnter a 3*3 matrix: ");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Output:
        System.out.println("\nOutput:");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
