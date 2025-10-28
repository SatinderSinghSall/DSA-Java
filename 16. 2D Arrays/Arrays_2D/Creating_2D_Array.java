package Arrays_2D;

import java.util.Scanner;

public class Creating_2D_Array {
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println("Enter 2D-Array elements For Below.");
        System.out.println("Array Rows " + rows + " & Columns " + columns + ": ");

        Scanner sc = new Scanner(System.in);
        // Input:
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output:
        System.out.println("\n2D - Array:");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
