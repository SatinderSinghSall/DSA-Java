// Problem: Largest & Smallest Number in a 2-D Array Matrix:

package Arrays_2D;

import java.util.Scanner;

public class Largest_Smallest_2DArray {
    public static void LargestSmallest_Algorithm() {
        System.out.println("\nProgram in Progress...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrix[][] = new int[3][3];
        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println("\n\tProgram: Largest & Smallest Number:");

        // User Inputs:
        System.out.println("\nEnter values for 3*3 Matrix:");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Output:
        System.out.println("Output:");
        for(int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        LargestSmallest_Algorithm();
    }
}
