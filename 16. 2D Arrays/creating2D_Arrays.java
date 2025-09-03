//! Creating a 2D Array:

import java.util.Scanner;

public class creating2D_Arrays {
    // method to search an element in a matrix
    public static boolean searchMatrixData(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("\nElement " + key + " found at cell: [" + i + "," + j + "]");
                    return true;
                }
            }
        }
        System.out.println("\nElement " + key + " not found.");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrix[][] = new int[3][3];
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println("\n\tCreating 2D Array:");

        // taking user-input and storing it
        System.out.print("\nEnter the matrix elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // displaying the matrix stored data
        System.out.println("\nThe elements in the matrix are:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // next-line
        }

        // method to search an element:
        searchMatrixData(matrix, 5);
    }
}
